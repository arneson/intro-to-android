package com.devies.simonarneson.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tw;
    private EditText et;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tw = findViewById(R.id.myAmazingTextView);
        tw.setText("I just changed programatically.");

        et = findViewById(R.id.myAmazingEditText);
        bt = findViewById(R.id.myAmazingButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInputText = "Hello" + et.getText().toString();
                tw.setText(userInputText);
            }
        };

        bt.setOnClickListener(listener);
    }
}
