package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) { //first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //second

        // extract intent extras information
        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra("count");
        Log.d("Data from Main Activity", receivedMessage);

        // grab the recycler view in second activity
        constraintLayout = findViewById(R.id.second_root_layout);
        linearLayout = findViewById(R.id.second_linear_layout);

        // create a textView and set the text to receivedMessage + " was passed from main activity."
        // add this textView to ConstraintLayout
        /**
        TextView textView = new TextView(this);
        textView.setText(receivedMessage + "was passed from main activity.");
        textView.setTextSize(30);
        constraintLayout.addView(textView);
         */
        // if you do not know how many views you will need to create
        for (int i = 0; i < Integer.parseInt(receivedMessage); i++) {
            TextView textView = new TextView(this);
            textView.setText("hello");
            linearLayout.addView(textView);
        }
    }
}
