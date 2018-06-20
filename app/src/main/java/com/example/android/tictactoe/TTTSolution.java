package com.example.android.tictactoe;

public class TTTSolution
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

    public void print()
    {
        System.out.println("Position " + position + "has a fitness of " + fitness);
    }
}
