package com.example.android.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainMenu extends AppCompatActivity
{
    public static final String DEBUGTAG = "CHRISVILLEGAS";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MediaPlayer background = MediaPlayer.create(MainMenu.this,R.raw.backgroundmusic);
        background.setLooping(true);
        background.start();

        Button Play = findViewById(R.id.PlayButton);
        Play.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent playIntent = new Intent(MainMenu.this, playOptions.class); //Points it to the Highscores.
                startActivity(playIntent);
            }
        });

        Button Scores = findViewById(R.id.Scores);
        Scores.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent playIntent = new Intent(MainMenu.this, Scores.class); //Points it to the Highscores.
                startActivity(playIntent);
            }
        });
    }


}
