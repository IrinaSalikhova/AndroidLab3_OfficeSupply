package com.cst3104.androidlab3_officesupply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent(); //This gets you the object nextPage from FirstActivity.java
        int thing1 = intent.getIntExtra("thing1", 0);
        int thing2 = intent.getIntExtra("thing2", 0);
        String total = intent.getStringExtra("total");

        //Button closeButton = findViewById(R.id.previousPageButton);

      //  previousButton.setOnClickListener(click -> {

      //      finish();

      //  } );
    }
}