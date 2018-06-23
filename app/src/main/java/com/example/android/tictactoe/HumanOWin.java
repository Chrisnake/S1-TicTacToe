package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HumanOWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_owin);

        Button replayHuman = findViewById(R.id.replayHuman);
        replayHuman.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent playIntent = new Intent(HumanOWin.this, Human.class); //Points it back to the human activity
                startActivity(playIntent);
            }
        });

        Button Home = findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent playIntent = new Intent(HumanOWin.this, MainMenu.class); //Points it back to the human activity
                startActivity(playIntent);
            }
        });
    }
}
