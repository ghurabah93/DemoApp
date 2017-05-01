package com.robpercival.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow ; 1 = red

    int activePlayer = 0;
    boolean isActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());

        int tapped = Integer.parseInt(counter.getTag().toString());

        int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

        if(gameState[tapped] == 2 && isActive) {

            gameState[tapped] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellowcoin);

                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.redcoin);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(500);

            for(int[] i : winningPositions) {
                if(gameState[i[0]] == gameState[i[1]] &&
                        gameState[i[1]] == gameState[i[2]] &&
                                gameState[i[0]] != 2) {
                    System.out.println("YOU HAVE WON");
                    isActive = false;
                    String winnerStr = "Red";
                    if(gameState[i[0]] == 0 ) {
                        winnerStr = "Yellow";
                    }
                    TextView winner = (TextView) findViewById(R.id.textView);
                    winner.setText(winnerStr +  " has won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                } else {
                    boolean isOver = true;
                    for (int counterState: gameState) {
                        if(counterState == 2) {
                            isOver = false;
                        }
                    }

                    if(isOver) {
                        TextView winner = (TextView) findViewById(R.id.textView);
                        winner.setText("It's a draw");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void playAgain(View view) {
        isActive = true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        int activePlayer = 0;


        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < grid.getChildCount(); i++) {
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
