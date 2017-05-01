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
        tom.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000);


        //ImageView jerry = (ImageView) findViewById(R.id.jerry);

        //jerry.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView tom = (ImageView) findViewById(R.id.tom);

        tom.setTranslationX(-1000f);
        tom.setTranslationY(-1000f);
    }
}
