package com.cst3104.androidlab3_officesupply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button clearButton = findViewById(R.id.clearButton);
        Button submitButton = findViewById(R.id.submitButton);

        clearButton.setOnClickListener(view -> {
            clearFields(view); //clear all fields with information
        });

        submitButton.setOnClickListener(view -> {
            countTotal(view); //count total price and suggest to show a bill
        });


    }

    private void countTotal (View view) {  //count total price and suggest to show a bill

        TextView totalPrice = findViewById(R.id.totalPrice);
        EditText thing1Amount = findViewById(R.id.thing1Amount);
        EditText thing2Amount = findViewById(R.id.thing2Amount);

        try {
            int thing1 = 0;
            int thing2 = 0;
            if (thing1Amount.getText().toString() != null) {
                thing1 = Integer.parseInt(thing1Amount.getText().toString());
            }
            if (thing2Amount.getText().toString() != null) {
                thing2 = Integer.parseInt(thing2Amount.getText().toString());
            }
            int total = thing1 + thing2*3;
            String totalString = new String(total + getString(R.string.currency));
            totalPrice.setText(totalString);
            String completeMessage = new String(getString(R.string.complete_message));
            String billMessage = new String(getString(R.string.bill_message));
            Intent nextPage = new Intent(this, MainActivity2.class);
            int finalThing = thing1;
            int finalThing1 = thing2;
            Snackbar snackbar = Snackbar.make(view, completeMessage, Snackbar.LENGTH_LONG).setAction(billMessage, click ->
            {
                nextPage.putExtra("thing1", finalThing);
                nextPage.putExtra("thing2", finalThing1);
                nextPage.putExtra("total", total );
                startActivity(nextPage);    //go to MainActivity2.java
            });
            snackbar.show();

        } catch (Exception ex) {
            String messageString = new String(getString(R.string.mistake_message));
            Snackbar snackbar = Snackbar.make(view, messageString, Snackbar.LENGTH_LONG);
            snackbar.show();
        }

    }

    private void clearFields (View view) {

        TextView totalPrice = findViewById(R.id.totalPrice);
        EditText thing1Amount = findViewById(R.id.thing1Amount);
        EditText thing2Amount = findViewById(R.id.thing2Amount);

        try {
            int try1 = 0;
            int try2 =0;
            if (thing1Amount != null) {
                try1 = Integer.parseInt(thing1Amount.getText().toString());
                thing1Amount.getText().clear();
            }
            if (thing2Amount != null) {
                try2 = Integer.parseInt(thing2Amount.getText().toString());
                thing2Amount.getText().clear();
            }
            int saveThing1 = try1;
            int saveThing2 = try2;
            String saveTotal = new String (totalPrice.getText().toString());

            totalPrice.setText(null);
            String messageString = new String(getString(R.string.clear_message));
            Snackbar snackbar = Snackbar.make(view, messageString, Snackbar.LENGTH_LONG).setAction("Undo", click -> restore(saveThing1,saveThing2,saveTotal) );
            snackbar.show();


        } catch (Exception ex) {
            String messageString = new String(getString(R.string.mistake_message));
            Snackbar snackbar = Snackbar.make(view, messageString, Snackbar.LENGTH_LONG);
            snackbar.show();
        }

    }

    private void restore (int thing1, int thing2, String total) {
        TextView totalPrice = findViewById(R.id.totalPrice);
        EditText thing1Amount = findViewById(R.id.thing1Amount);
        EditText thing2Amount = findViewById(R.id.thing2Amount);
        if (thing1 != 0) {
            thing1Amount.setText(thing1 +"");
        }
        if (thing2 != 0) {
            thing2Amount.setText(thing2 +"");
        }
        totalPrice.setText(total);

    }
}