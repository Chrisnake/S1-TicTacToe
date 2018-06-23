package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        TextView text = findViewById(R.id.XWins);
        String X = Integer.toString(updateXScores());
        text.setText(X);

        TextView text2 = findViewById(R.id.OWins);
        String O = Integer.toString(updateOScores());
        text2.setText(O);
    }

    public int updateXScores()
    {
        return(CPU.getXScores() +  Human.getXScores());
    }

    public int updateOScores()
    {
        return(CPU.getOscores() +  Human.getOScores());
    }
}
