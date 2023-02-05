# TicTacToe
My attempt at a simple TicTaceToe game.

Rules:
Three by three game board
Two players: “X” and “O”
Nine turn game
First player to get a horizontal, vertical, or diagonal line of three consecutive “X”s or “O”s wins
- If this does not happen for either player in nine turns, the game ends in a draw

Structure:
Uses a 2D String array where the "O" and "X" correspond to themselves
When three Os or Xs are in some form of a line the game ends
Game only lasts 9 turns no matter what
There is a 50% chance that either “X” or “O” will be allowed to go first
The Os and Xs are inputted by players based on where they want to place them
- The state of the array is updated and displayed each turn
    - Starts as a 3 by 3 holding the numbers 1 to 9 which correspond to the number the player will have to input to place a 1 or a 0 there
Three end scenarios (X wins, O wins, Draw)
