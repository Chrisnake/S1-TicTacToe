![tictactoe cover](https://user-images.githubusercontent.com/32743122/42295608-178bc602-7fe4-11e8-9793-c3eb94bbc698.png)

# Summer 2018 Project 1: Tic Tac Toe 

For my first project I have re-created the classic Tic Tac Toe game on Android Studio. The game involves two playable modes 
  1. Playing against another user (Pass and play)
  2. Playing against a CPU 
  
The CPU logic is based of fitness points and evaluates each possible outcome that the CPU can undergo. The CPU will therefore read every possible occurance that is possible on the active board and choose the best fitness based on the outcome that the specific tile takes. 

For example, free spaces on the board where the outcome results in no loss, or no win for both the User and the CPU will be given a fitness rating of 0. Whilst spaces on the board where the user can win will be given a fitness of 10, and fitnesses where they can lose on the next round will be given 15.

I have designed the game to follow a minimalistic theme, due to the fact that Tic tac toe is a simplistic game. 
