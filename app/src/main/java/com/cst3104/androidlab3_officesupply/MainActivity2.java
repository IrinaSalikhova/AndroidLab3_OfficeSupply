package com.cst3104.androidlab3_officesupply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView thing1amount = findViewById(R.id.thing1amount);
        TextView thing2amount = findViewById(R.id.thing2amount);
        TextView thing1total = findViewById(R.id.thing1total);
        TextView thing2total = findViewById(R.id.thing2total);
        TextView totality = findViewById(R.id.totality);

        Intent intent = getIntent(); //This gets you the object nextPage from FirstActivity.java
        int thing1 = intent.getIntExtra("thing1", 0);
        int thing2 = intent.getIntExtra("thing2", 0);
        int thing2price = thing2*3;
        int total = intent.getIntExtra("total", 0);

        thing1amount.setText(thing1+"");
        thing2amount.setText(thing2+"");
        thing1total.setText(getString(R.string.currency_symbol)+thing1);
        thing2total.setText(getString(R.string.currency_symbol)+thing2price);
        totality.setText(total+"" +getString(R.string.currency));


        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(click -> {
            finish();
                });
    }
}