package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class CPU extends AppCompatActivity {

    private static ArrayList<Integer> CPUmoveList = new ArrayList<Integer>();
    private static int[] CBoard = {7, 7, 7, 7, 7, 7, 7, 7, 7};
    public static int XScores;
    public static int OScores;
    Button B1, B2, B3, B4, B5, B6, B7, B8, B9;
    ArrayList<Button> buttons = new ArrayList<Button>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);
        CPUmoveList.add(1);//Adding 1 to the moveList array list to state that the first move will go to X.
        System.out.println(Arrays.toString(CBoard));

        B1 = findViewById(R.id.B1);
        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
               Move(B1, 0);
               B1.postDelayed(new Runnable()
               {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B2 = findViewById(R.id.B2);
        B2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B2, 1);
                B2.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B3 = findViewById(R.id.B3);
        B3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B3, 2);
                B3.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B4 = findViewById(R.id.B4);
        B4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B4, 3);
                B4.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B5 = findViewById(R.id.B5);
        B5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B5, 4);
                B5.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B6 = findViewById(R.id.B6);
        B6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B6, 5);
                B6.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B7 = findViewById(R.id.B7);
        B7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B7, 6);
                B7.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B8 = findViewById(R.id.B8);
        B8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B8, 7);
                B8.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        B9 = findViewById(R.id.B9);
        B9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Move(B9, 8);
                B9.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        CPUMove(bestPosition(fitnessList()));
                    }
                }, 550);
            }});

        final Button Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                B1.setText(""); B2.setText(""); B3.setText("");B4.setText(""); B5.setText(""); B6.setText(""); B7.setText(""); B8.setText(""); B9.setText("");
                resetBoard();
            }
        });

        buttons.add(B1); buttons.add(B2); buttons.add(B3); buttons.add(B4);
        buttons.add(B5); buttons.add(B6); buttons.add(B7); buttons.add(B8); buttons.add(B9);
    }

    public Button findButton(int bestPosition)
    {
        return (buttons.get(bestPosition));
    }

    public void CPUMove(int bestPosition) //Gets the best position for the CPU and moves using that best position.
    {
        if (turnCheck()) //If turnCheck returns true, then the last value was a 1, thus it was an X.
        {
            findButton(bestPosition).setText("X");
            CPUmoveList.add(0);//If it was 1, then we add 0 to the array list, because the next move should be from the nought.
            System.out.println("CPU Position: " + bestPosition);
            TTTSolution.updateArray(CBoard, bestPosition, 1);
            checkWin(CBoard);
            CPUcheckDraw(CBoard); //If there is a draw (=true)
        }
        else //If false, then the last value was a 0, thus it was a O.
        {
            findButton(bestPosition).setText("O");
            CPUmoveList.add(1);
            System.out.println("CPU Position: " + bestPosition);
            TTTSolution.updateArray(CBoard, bestPosition, 0);
            checkWin(CBoard);
            CPUcheckDraw(CBoard); //If there is a draw (=true)
        }
    }

    protected void Move(Button b, int position)
    {
            if (turnCheck()) //If turnCheck returns true, then the last value was a 1, thus it was an X.
            {
                b.setText("X");
                CPUmoveList.add(0);//If it was 1, then we add 0 to the array list, because the next move should be from the nought.
                System.out.println("Human Position: " + position);
                TTTSolution.updateArray(CBoard, position, 1);
                checkWin(CBoard);
                CPUcheckDraw(CBoard); //If there is a draw (=true)
            } else //If false, then the last value was a 0, thus it was a O.
            {
                b.setText("O");
                CPUmoveList.add(1);
                System.out.println("Human Position: " + position);
                TTTSolution.updateArray(CBoard, position, 0);
                checkWin(CBoard);
                CPUcheckDraw(CBoard); //If there is a draw (=true)
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
            simulatedBoard = CBoard.clone();
            if (!turnCheck()) //If turnCheck = false, then the last value was a 1. Now it is 0's turn.
            {
                simulatedBoard[reviewFitness] = 0;  //FIRSTLY - CHECKS IF THERE IS A LOSS BY SEEING THE NEXT OPPONENTS MOVE
                if (TTTSolution.CPUcheckLose(simulatedBoard, 0))
                {
                    TTTSolution hey = new TTTSolution(5,reviewFitness);
                    Fitnesses.add(hey);
                    System.out.println("Position " + reviewFitness + " has a Loss");
                }
                else
                {
                    simulatedBoard[reviewFitness] = 1;
                    if (TTTSolution.CPUCheckWin(simulatedBoard, 0) == 1) //Then check to see if there is a win on the "simulated board"
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
            else if (turnCheck()) //If the last move was made by a 1, then it is 0's turn
            {
                simulatedBoard[reviewFitness] = 1;  //FIRSTLY - CHECKS IF THERE IS A LOSS BY SEEING THE NEXT OPPONENTS MOVE
                if (TTTSolution.CPUcheckLose(simulatedBoard, 1))
                {
                    TTTSolution hey = new TTTSolution(5,reviewFitness);
                    Fitnesses.add(hey);
                    System.out.println("Position " + reviewFitness + " has a Loss");
                }
                else
                {
                    simulatedBoard[reviewFitness] = 0;
                    if (TTTSolution.CPUCheckWin(simulatedBoard, 1) == 0) //Then check to see if there is a win on the "simulated board"
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
        for(int hey : CBoard)
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

    protected void CPUcheckDraw(int Board[]) //Checks the global array to see if there are no 7's available.
    {
        int count = 0;
        for(int i = 0; i < 9; i++)
        {
            if(Board[i] == 7)
            {
                break;
            }
            else
            {
                count++;
            }
        }

        if(count == 9)
        {
            Intent playIntent = new Intent(CPU.this, CPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            System.out.println("It's a draw!!!");
        }
    }

    protected void resetBoard()
    {
        Intent playIntent = new Intent(CPU.this, CPU.class); //Points it to the Human finish
        TTTSolution.resetArray(CBoard);
        System.out.println("Reset Clicked");
        startActivity(playIntent);
    }

    protected static boolean turnCheck() //This method checks who's turn it is, thus it will get the global arraylist and check what the last move was.
    {
        int check =  CPUmoveList.get(CPUmoveList.size() - 1);
        if (check == 0) //If the final move was made by a nought (O).
        {
            return(false);
        }
        else
        {
            return(true);
        }
    }

    protected boolean checkWin(int Board[]) //Consistently checks the global array after it has been altered to see if there is a win
    {
        boolean check = false;
        if (Board[0] == 1 && Board[1] == 1 && Board[2] == 1) //FIRST ROW ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[0] == 0 && Board[1] == 0 && Board[2] == 0) //FIRST ROW ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[3] == 1 && Board[4] == 1 && Board[5] == 1) //SECOND ROW ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[3] == 0 && Board[4] == 0 && Board[5] == 0) //SECOND ROW ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[6] == 1 && Board[7] == 1 && Board[8] == 1) //THIRD ROW ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[6] == 0 && Board[7] == 0 && Board[8] == 0) //THIRD ROW ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[0] == 0 && Board[3] == 0 && Board[6] == 0) //FIRST COLUMN ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[0] == 1 && Board[3] == 1 && Board[6] == 1) //FIRST COLUMN ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[1] == 0 && Board[4] == 0 && Board[7] == 0) //SECOND COLUMN ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[1] == 1 && Board[4] == 1 && Board[7] == 1) //SECOND COLUMN ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[2] == 0 && Board[5] == 0 && Board[8] == 0) //THIRD COLUMN ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[2] == 1 && Board[5] == 1 && Board[8] == 1) //THIRD COLUMN ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[0] == 1 && Board[4] == 1 && Board[8] == 1) //DIAGONAL ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        else if (Board[0] == 0 && Board[4] == 0 && Board[8] == 0) //DIAGONAL ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[2] == 0 && Board[4] == 0 && Board[6] == 0) //DIAGONAL 2 ALL O'S
        {
            Intent playIntent = new Intent(CPU.this, OWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            OScores++;
            check = true;
        }

        else if (Board[2] == 1 && Board[4] == 1 && Board[6] == 1) //DIAGONAL 2 ALL X'S
        {
            Intent playIntent = new Intent(CPU.this, XWinCPU.class); //Points it to the Human finish
            startActivity(playIntent);
            TTTSolution.resetArray(Board);
            XScores++;
            check = true;
        }

        return check;
    }

    public static int getXScores()
    {
        return XScores;
    }

    public static int getOscores()
    {
        return OScores;
    }
}

