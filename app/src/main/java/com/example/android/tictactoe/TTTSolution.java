package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Arrays;

public class TTTSolution extends AppCompatActivity
{
    int fitness;
    int position;

    public TTTSolution(int f, int p)
    {
        fitness = f; //Fitness is the fitness of the solution at position p
        position = p; //Position is the position in the arraylist
    }

    public int getFitness()
    {
        return (fitness);
    }

    public int getPosition()
    {
        return (position);
    }

    protected static boolean repeatCheck(int Board[], int position) //This method checks if there is a repeat in the same move.
    {
        if(Board[position] == 7) //If the position on the board equals 7, then there is no repeat thus return false
        {
            System.out.println("No Repeat at Position: " + position);
            return false;
        }

        System.out.println("Repeat at Position: " + position);
        return true;
    }

    public static void resetArray(int Board[]) //Reset the game
    {
        for(int reset = 0; reset < 9; reset++)
        {
            Board[reset] = 7;
        }
    }

    public static void updateArray(int Board[], int x, int XorO) //Updates global array to change the 7 into a 1 or a 0.
    {
        Board[x] = XorO;
        System.out.print("Board state updated! : " + Arrays.toString(Board));
    }

    public boolean checkWin(int Board[]) //Consistently checks the global array after it has been altered to see if there is a win
    {
        boolean check = false;
        if (Board[0] == 1 && Board[1] == 1 && Board[2] == 1) //FIRST ROW ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[0] == 0 && Board[1] == 0 && Board[2] == 0) //FIRST ROW ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[3] == 1 && Board[4] == 1 && Board[5] == 1) //SECOND ROW ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[3] == 0 && Board[4] == 0 && Board[5] == 0) //SECOND ROW ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[6] == 1 && Board[7] == 1 && Board[8] == 1) //THIRD ROW ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[6] == 0 && Board[7] == 0 && Board[8] == 0) //THIRD ROW ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[0] == 0 && Board[3] == 0 && Board[6] == 0) //FIRST COLUMN ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[0] == 1 && Board[3] == 1 && Board[6] == 1) //FIRST COLUMN ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[1] == 0 && Board[4] == 0 && Board[7] == 0) //SECOND COLUMN ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[1] == 1 && Board[4] == 1 && Board[7] == 1) //SECOND COLUMN ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[2] == 0 && Board[5] == 0 && Board[8] == 0) //THIRD COLUMN ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[2] == 1 && Board[5] == 1 && Board[8] == 1) //THIRD COLUMN ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[0] == 1 && Board[4] == 1 && Board[8] == 1) //DIAGONAL ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[0] == 0 && Board[4] == 0 && Board[8] == 0) //DIAGONAL ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[2] == 0 && Board[4] == 0 && Board[6] == 0) //DIAGONAL 2 ALL O'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        else if (Board[2] == 1 && Board[4] == 1 && Board[6] == 1) //DIAGONAL 2 ALL X'S
        {
            Intent playIntent = new Intent(TTTSolution.this, humanFinish.class); //Points it to the Human finish
            startActivity(playIntent);
            resetArray(Board);
            check = true;
        }

        return check;
    }

    public static int CPUCheckWin(int CPUBoard[], int x) //Consistently checks the global array after it has been altered to see if there is a win
    {
        int Win = -1;
        if(x == 0) //If the last move was made by an 0, then it is X's turn.
        {
            if(XLogic(CPUBoard)) //Check if X can win
            {
                Win = 1;
            }
        }
        else if(x == 1)
        {
            if(OLogic(CPUBoard)) //Check if O can win
            {
                Win = 0;
            }
        }
        return Win;
    }

    public static boolean CPUcheckLose(int CPUBoard[], int x) //This method checks to see if there is a loss on any position on the board.
    {
        boolean check = false;
        if(x == 1) //If the last turn was made by an X, then it is O's go. Therefore check if X can win next round, thus O loses.
        {
            if (XLogic(CPUBoard)) //iF Xlogic is true, then that means that X can win next turn
            {
                check = true;
            }
        }
        else if (x == 0) //If the last move was a O, then it is X's go, check if O can win.
        {
            if (OLogic(CPUBoard))
            {
                check = true;
            }
        }

        return check;
    }

    public static boolean XLogic(int CPUBoard[]) //Handles the logic where an X can win
    {
        boolean check = false;
        if (CPUBoard[0] == 1 && CPUBoard[1] == 1 && CPUBoard[2] == 1) //FIRST ROW ALL X'S
        {
            check = true;
            System.out.println("FIRST ROW ALL X'S WIN!");
        }
        else if (CPUBoard[3] == 1 && CPUBoard[4] == 1 && CPUBoard[5] == 1) //SECOND ROW ALL X'S
        {
            check = true;
            System.out.println("SECOND ROW ALL X'S WIN!");
        }
        else if (CPUBoard[6] == 1 && CPUBoard[7] == 1 && CPUBoard[8] == 1) //THIRD ROW ALL X'S
        {
            check = true;
            System.out.println("THIRD ROW ALL X'S WIN!");
        }
        else if (CPUBoard[0] == 1 && CPUBoard[3] == 1 && CPUBoard[6] == 1) //FIRST COLUMN ALL X'S
        {
            check = true;
            System.out.println("FIRST COLUMN ALL X'S WIN!");
        }
        else if (CPUBoard[1] == 1 && CPUBoard[4] == 1 && CPUBoard[7] == 1) //SECOND COLUMN ALL X'S
        {
            check = true;
            System.out.println("SECOND COLUMN ALL X'S WIN!");
        }
        else if (CPUBoard[2] == 1 && CPUBoard[5] == 1 && CPUBoard[8] == 1) //THIRD COLUMN ALL X'S
        {
            check = true;
            System.out.println("THIRD COLUMN ALL X'S WIN!");
        }
        else if (CPUBoard[0] == 1 && CPUBoard[4] == 1 && CPUBoard[8] == 1) //DIAGONAL ALL X'S
        {
            check = true;
            System.out.println("DIAGONAL 1 ALL X'S WIN!");
        }
        else if (CPUBoard[2] == 1 && CPUBoard[4] == 1 && CPUBoard[6] == 1) //DIAGONAL 2 ALL X'S
        {
            check = true;
            System.out.println("DIAGONAL 2 ALL X'S WIN!");
        }

        return check;
    }

    public static boolean OLogic(int CPUBoard[]) //Handles the logic where an O can win
    {
        boolean check = false;
        if (CPUBoard[0] == 0 && CPUBoard[1] == 0 && CPUBoard[2] == 0) //FIRST ROW ALL X'S
        {
            check = true;
            System.out.println("FIRST ROW ALL 0'S WIN!");
        }
        else if (CPUBoard[3] == 0 && CPUBoard[4] == 0 && CPUBoard[5] == 0) //SECOND ROW ALL X'S
        {
            check = true;
            System.out.println("SECOND ROW ALL 0'S WIN!");
        }
        else if (CPUBoard[6] == 0 && CPUBoard[7] == 0 && CPUBoard[8] == 0) //THIRD ROW ALL X'S
        {
            check = true;
            System.out.println("THIRD ROW ALL 0'S WIN!");
        }
        else if (CPUBoard[0] == 0 && CPUBoard[3] == 0 && CPUBoard[6] == 0) //FIRST COLUMN ALL X'S
        {
            check = true;
            System.out.println("FIRST COLUMN ALL 0'S WIN!");
        }
        else if (CPUBoard[1] == 0 && CPUBoard[4] == 0 && CPUBoard[7] == 0) //SECOND COLUMN ALL X'S
        {
            check = true;
            System.out.println("SECOND COLUMN ALL 0'S WIN!");
        }
        else if (CPUBoard[2] == 0 && CPUBoard[5] == 0 && CPUBoard[8] == 0) //THIRD COLUMN ALL X'S
        {
            check = true;
            System.out.println("THIRD COLUMN ALL 0'S WIN!");
        }
        else if (CPUBoard[0] == 0 && CPUBoard[4] == 0 && CPUBoard[8] == 0) //DIAGONAL ALL X'S
        {
            check = true;
            System.out.println("DIAGONAL 1 ALL 0'S WIN!");
        }
        else if (CPUBoard[2] == 0 && CPUBoard[4] == 0 && CPUBoard[6] == 0) //DIAGONAL 2 ALL X'S
        {
            check = true;
            System.out.println("DIAGONAL 2 ALL 0'S WIN!");
        }

        return check;
    }
}
