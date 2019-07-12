# Summer 2018 Project 1: Tic Tac Toe 

## Game Features
For my first project I have re-created the classic Tic Tac Toe game on Android Studio. The game involves two playable modes 
  1. Playing against another user (Pass and play)
  2. Playing against a CPU 

### Game Theory
The CPU logic is based of fitness points and evaluates each possible outcome that the CPU can undergo. The CPU will therefore read every possible occurance that is possible on the active board and choose the best fitness based on the outcome that the specific tile takes. 

#### Game Theory Examples

```
Free spaces on the board where, outcome != loss || opponentwin => fitness rating of 0.
```

```
Whilst spaces on the board where, user == win => fitness rating of 10. 
```

```
Fitnesses where they can lose on the next round will be given 15.
```

![tictactoe cover](https://user-images.githubusercontent.com/32743122/42295608-178bc602-7fe4-11e8-9793-c3eb94bbc698.png)

