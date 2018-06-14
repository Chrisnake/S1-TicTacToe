package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class playOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_options);

        Button Human = findViewById(R.id.VSHuman);
        Human.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent playIntent = new Intent(playOptions.this, Human.class);
                startActivity(playIntent);
            }
        });
    }
}
