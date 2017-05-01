package com.robpercival.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.myTextField);
        EditText myPasswordField = (EditText) findViewById(R.id.myPasswordField);

        Log.i("Info", "Your username is : " + myTextField.getText().toString() + " and your password is " + myPasswordField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
