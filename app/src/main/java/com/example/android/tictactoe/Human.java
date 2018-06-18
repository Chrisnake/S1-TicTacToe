package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Human extends AppCompatActivity
{
    private ArrayList<Integer> moveList = new ArrayList<Integer>();
    private int Board[] = {7, 7, 7, 7, 7, 7, 7, 7, 7};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);
        moveList.add(1);//Adding 1 to the moveList array list to state that the first move will go to X.
        System.out.println(Arrays.toString(Board));

        final Button B1 = findViewById(R.id.B1);
        B1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 0;
                Move(B1, position);
            }
        });

        final Button B2 = findViewById(R.id.B2);
        B2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 1;
                Move(B2, position);
            }
        });

        final Button B3 = findViewById(R.id.B3);
        B3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 2;
                Move(B3, position);
            }
        });

        final Button B4 = findViewById(R.id.B4);
        B4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 3;
                Move(B4, position);
            }
        });

        final Button B5 = findViewById(R.id.B5);
        B5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 4;
                Move(B5, position);
            }
        });

        final Button B6 = findViewById(R.id.B6);
        B6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 5;
                Move(B6, position);
            }
        });

        final Button B7 = findViewById(R.id.B7);
        B7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 6;
                Move(B7, position);
            }
        });

        final Button B8 = findViewById(R.id.B8);
        B8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 7;
                Move(B8, position);
            }
        });

        final Button B9 = findViewById(R.id.B9);
        B9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 8;
                Move(B9, position);
            }
        });

        final Button Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                B1.setText(""); B2.setText(""); B3.setText(""); B4.setText(""); B5.setText(""); B6.setText(""); B7.setText(""); B8.setText(""); B9.setText("");
            }
        });
    }

    //Coding logic for X's and O's.

    private boolean turnCheck() //This method checks who's turn it is, thus it will get the global arraylist and check what the last move was.
    {
       int check =  moveList.get(moveList.size() - 1);
       if (check == 0) //If the final move was made by a nought (O).
       {
           return(false);
       }
       else
       {
           return(true);
       }
    }

    private void Move(Button b, int position)
    {
        if (turnCheck()) //If turnCheck returns true, then the last value was a 1, thus it was an X.
        {
            b.setText("X");
            moveList.add(0);//If it was 1, then we add 0 to the array list, because the next move should be from the nought.
            int X = getN(position);
            System.out.println("Board Position: " + X);
            updateArray(X, 1);
            checkWin();
            checkDraw(); //If there is a draw (=true)

        }
        else //If false, then the last value was a 0, thus it was a O.
        {
            b.setText("O");
            moveList.add(1);
            int X = getN(position);
            System.out.println("Board Position: " + X);
            updateArray(X, 0);
            checkWin();
            checkDraw(); //If there is a draw (=true)
        }
    }

    private int getN(int n)
    {
        return (n);
    }

    private void resetArray() //Reset the game
    {
        for(int reset = 0; reset < 9; reset++)
        {
            Board[reset] = 7;
        }
    }

    private void updateArray(int x,int XorO) //Updates global array to change the 7 into a 1 or a 0.
    {
        Board[x] = XorO;
        System.out.print(Arrays.toString(Board));
    }

    private boolean checkDraw() //Checks the global array to see if there are no 7's available.
    {
        boolean check = false;
        int count = 0;
        for(int i = 0; i < 9; i++)
        {
            if(Board[i] == 7)
            {
                check = false;
                break;
            }
            else
            {
                count++;
            }
        }

        if(count == 9)
        {
            check = true;
            Intent playIntent = new Intent(Human.this, Human.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
            System.out.println("It's a draw!!!");
        }

        return(check);
    }

    private void checkWin() //Consistently checks the global array after it has been altered to see if there is a win
    {
        if (Board[0] == 1 && Board[1] == 1 && Board[2] == 1) //FIRST ROW ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[0] == 0 && Board[1] == 0 && Board[2] == 0) //FIRST ROW ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[3] == 1 && Board[4] == 1 && Board[5] == 1) //SECOND ROW ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[3] == 0 && Board[4] == 0 && Board[5] == 0) //SECOND ROW ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[6] == 1 && Board[7] == 1 && Board[8] == 1) //THIRD ROW ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[6] == 0 && Board[7] == 0 && Board[8] == 0) //THIRD ROW ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[0] == 0 && Board[3] == 0 && Board[6] == 0) //FIRST COLUMN ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[0] == 1 && Board[3] == 1 && Board[6] == 1) //FIRST COLUMN ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[1] == 0 && Board[4] == 0 && Board[7] == 0) //SECOND COLUMN ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[1] == 1 && Board[4] == 1 && Board[7] == 1) //SECOND COLUMN ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[2] == 0 && Board[5] == 0 && Board[8] == 0) //THIRD COLUMN ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[2] == 1 && Board[5] == 1 && Board[8] == 1) //THIRD COLUMN ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[0] == 1 && Board[4] == 1 && Board[8] == 1) //DIAGONAL ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[0] == 0 && Board[4] == 0 && Board[8] == 0) //DIAGONAL ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[2] == 0 && Board[4] == 0 && Board[6] == 0) //DIAGONAL 2 ALL O'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }

        else if (Board[2] == 1 && Board[4] == 1 && Board[6] == 1) //DIAGONAL 2 ALL X'S
        {
            Intent playIntent = new Intent(Human.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray();
        }
    }
}
