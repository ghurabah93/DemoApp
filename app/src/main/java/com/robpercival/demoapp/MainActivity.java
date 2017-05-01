package com.robpercival.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void changer(View view) {
        ImageView tom = (ImageView) findViewById(R.id.tom);
        ImageView jerry = (ImageView) findViewById(R.id.jerry);
        tom.animate().alpha(0f).setDuration(2000);
        jerry.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
