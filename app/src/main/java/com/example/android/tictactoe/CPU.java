package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class CPU extends Human {

    private ArrayList<Integer> moveList = new ArrayList<Integer>();
    private static int[] Board = {7, 7, 7, 7, 7, 7, 7, 7, 7};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);
        moveList.add(1);//Adding 1 to the moveList array list to state that the first move will go to X.
        System.out.println(Arrays.toString(Board));

        final Button B1 = findViewById(R.id.B1);
        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 0;
                Move(B1, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B2 = findViewById(R.id.B2);
        B2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 1;
                Move(B2, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B3 = findViewById(R.id.B3);
        B3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 2;
                Move(B3, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B4 = findViewById(R.id.B4);
        B4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 3;
                Move(B4, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B5 = findViewById(R.id.B5);
        B5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 4;
                Move(B5, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B6 = findViewById(R.id.B6);
        B6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 5;
                Move(B6, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B7 = findViewById(R.id.B7);
        B7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 6;
                Move(B7, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B8 = findViewById(R.id.B8);
        B8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 7;
                Move(B8, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button B9 = findViewById(R.id.B9);
        B9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                int position = 8;
                Move(B9, position);
                CPUMove(B1,bestPosition(fitnessList()));
            }
        });

        final Button Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                B1.setText("");
                B2.setText("");
                B3.setText("");
                B4.setText("");
                B5.setText("");
                B6.setText("");
                B7.setText("");
                B8.setText("");
                B9.setText("");
            }
        });
    }

    public void CPUMove(Button b, int bestPosition) //Gets the best position for the CPU and moves using that best position.
    {
        if (turnCheck()) //If turnCheck returns true, then the last value was a 1, thus it was an X.
        {
            b.setText("X");
            moveList.add(0);//If it was 1, then we add 0 to the array list, because the next move should be from the nought.
            int X = getN(bestPosition);
            System.out.println("Board Position: " + X);
            updateArray(X, 1);
            checkWin();
            checkDraw(); //If there is a draw (=true)

        }
        else //If false, then the last value was a 0, thus it was a O.
        {
            b.setText("O");
            moveList.add(1);
            int X = getN(bestPosition);
            System.out.println("Board Position: " + X);
            updateArray(X, 0);
            checkWin();
            checkDraw(); //If there is a draw (=true)
        }
    }
    public ArrayList<TTTSolution> fitnessList() //This returns the list of all possible fitnesses and their respective positions in the Board.
    {
        //10 FITNESS IF THEY CAN WIN - MAIN PRIORITY
        //0 FITNESS IF THERE IS NO WIN OR LOSS - FINAL PRIORITY
        //5 FITNESS IF THEY CAN LOSE - SECOND PRIORITY
        int simulatedBoard[];
        ArrayList<TTTSolution> Fitnesses = new ArrayList<TTTSolution>();
        ArrayList<Integer> CPUMoves = possibleMoves();

        for(int reviewFitness: CPUMoves)
        {
            simulatedBoard = Board.clone();
            if (turnCheck() == false) //If turnCheck = false, then the last value was a 1. Now it is 0's turn.
            {
                System.out.print(reviewFitness + "POSITION BEING REVIEWED");
                simulatedBoard[reviewFitness] = 0;  //FIRSTLY - CHECKS IF THERE IS A LOSS BY SEEING THE NEXT OPPONENTS MOVE
                //System.out.println("Changed simulated Board " + Arrays.toString(simulatedBoard));
                System.out.println(Arrays.toString(simulatedBoard));
                if (checkLose(simulatedBoard, 0))
                {
                    TTTSolution hey = new TTTSolution(5,reviewFitness);
                    Fitnesses.add(hey);
                    System.out.println("Position " + reviewFitness + " has a Loss");
                }
                else
                {
                    simulatedBoard[reviewFitness] = 1;
                    if (checkWin(simulatedBoard, 0) == 1) //Then check to see if there is a win on the "simulated board"
                    {
                        //IF THE LAST MOVE WAS BY A 0, THEN CHECK TO SEE IF ANY 1'S CAN WIN
                        TTTSolution hey = new TTTSolution(10,reviewFitness);
                        Fitnesses.add(hey);
                        System.out.println("Position " + reviewFitness + " has a X win!");
                    }
                    else
                    {
                        TTTSolution hey = new TTTSolution(0,reviewFitness);
                        Fitnesses.add(hey);
                        System.out.println("Position " + reviewFitness + " does not have a win!");
                    }
                }
            }
            else if (turnCheck() == true) //If the last move was made by a 1, then it is 0's turn
            {
                System.out.print(reviewFitness + "POSITION BEING REVIEWED");
                simulatedBoard[reviewFitness] = 1;  //FIRSTLY - CHECKS IF THERE IS A LOSS BY SEEING THE NEXT OPPONENTS MOVE
                //System.out.println("Changed simulated Board " + Arrays.toString(simulatedBoard));
                System.out.println(Arrays.toString(simulatedBoard));
                if (checkLose(simulatedBoard, 1))
                {
                    TTTSolution hey = new TTTSolution(5,reviewFitness);
                    Fitnesses.add(hey);
                    System.out.println("Position " + reviewFitness + " has a Loss");
                }
                else
                {
                    simulatedBoard[reviewFitness] = 0;
                    if (checkWin(simulatedBoard, 1) == 0) //Then check to see if there is a win on the "simulated board"
                    {
                        //IF THE LAST MOVE WAS BY A 0, THEN CHECK TO SEE IF ANY 1'S CAN WIN
                        TTTSolution hey = new TTTSolution(10,reviewFitness);
                        Fitnesses.add(hey);
                        System.out.println("Position " + reviewFitness + " has a X win!");
                    }
                    else
                    {
                        TTTSolution hey = new TTTSolution(0,reviewFitness);
                        Fitnesses.add(hey);
                        System.out.println("Position " + reviewFitness + " does not have a win!");
                    }
                }
            }
        }
        return Fitnesses;
    }

    public static int bestPosition(ArrayList<TTTSolution> fitnesses) //Uses the fitness' arraylist to find the best fitness thus the best position for the AI to go to
    {
        ArrayList<Integer> fitnessList = new ArrayList<Integer>();
        int bestPosition = 0;
        for(int i = 0; i < fitnesses.size(); i++)
        {
            int fitness = fitnesses.get(i).getFitness();
            fitnessList.add(fitness);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < fitnessList.size(); i++)
        {
            if(fitnessList.get(i) > max)
            {
                max = fitnessList.get(i);
                bestPosition = fitnesses.get(i).getPosition();
                System.out.println("Position " + bestPosition + " has the best fitness " + max);
            }
        }
        return bestPosition;
    }

    protected static ArrayList<Integer> possibleMoves() //This method is for the CPU and checks the possible moves and puts it in an arraylist
    {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        int increment = 0;
        for(int hey : Board)
        {
            if(hey == 7)//if there is a 7 then add it to possible arraylist
            {
                possibleMoves.add(increment);
                System.out.println("Position " + increment + " is a possible move");
            }

            increment++;
        }
        return possibleMoves;
    }
    protected static boolean checkLose(int CPUBoard[], int x) //This method checks to see if there is a loss on any position on the board.
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
    protected static boolean XLogic(int CPUBoard[])
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
    protected static boolean OLogic(int CPUBoard[])
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

    protected static int checkWin(int CPUBoard[], int x) //Consistently checks the global array after it has been altered to see if there is a win
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
}

