package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // define variables outside of methods
    private Button button_hi;
    private int number = 0;
    private TextView textView_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // part of the android life cycle

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // links the activity to the layout called activity_main

        // look up the button by its id
        button_hi = findViewById(R.id.button_hello);
        textView_count = findViewById(R.id.textView_count);

        // System.out.println("We are in this loop.");
        // create logs to keep track of the errors
        Log.d("MainActivity", "I was not able to see the toast when clicking the  button");
        // tag --> location: where this is found
        // msg --> log information, what happened
        // add an event listener to listen for the click
        button_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle what happens after I click
                //sayHello(v);
                launchNextActivity(v);
            }
        });

        // when click happens, I do something

    }

    public void sayHello (View view) {
        // create a toast with a message saying hello
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT); // short --> 2 secs, long --> 3 or 4 secs
        toast.show();
    }

    public void countUp (View view) {
        // increment the value of number
        // set the text of the text view to the number
        number++;
        // when you see an object you want to check if it's not null
        if (textView_count != null) {
            textView_count.setText(Integer.toString(number)); // setText takes a string

        }

    }

    public void launchNextActivity (View view) {
        // create an intent and you need to specify from and to
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        // data field
        // intent extras
        // both can pack data and send to the targeted activity

        // intent extras:
        // key/value pairs in a Bundle

        // I want to pass the count number through intent to second activity and display in second activity
        // 5 was passed.

        String message = textView_count.getText().toString();
        intent.putExtra("count", message); // key = count, value = message
        startActivity(intent);
    }
}