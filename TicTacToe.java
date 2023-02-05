/*
 * This is a program meant to replicate the simple functions in the game Tic Tac Toe.
 * Created by: Oluwatimilehin Akibu
 */
import java.util.*;

public class TicTacToe {
    public static Scanner scan = new Scanner(System.in);
    private static String [][] stateOfBoard = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}}; // game board that holds all values; uses String type
    private static boolean gameEnd = false;
    private static int turnNumber = 1;
    
    public static void play() {
        String first = "";
        int boardChoice;
        

        if (((int) (Math.random()*10) + 1) > 6) // 50% chance for X or O to go first
            first = "'X'";
        else
            first = "'O'";

        while (turnNumber <= 9 && gameEnd == false) { // ends game after 9 turns or if an endcase is fulfilled
            int boardRow = 0; // this needs to reset every round
            
            if (turnNumber == 1) // decides on an opening statement for the game
                System.out.println("This is the state of the board: "); // choice 1 (for turn 1)
            else
                System.out.println("This is the board's new state: "); // choice 2 (for rest of turns)

            for (int i = 0; i < stateOfBoard.length; i++)
                System.out.println(Arrays.toString(stateOfBoard[i])); // prints out the current game state
            
            System.out.print("Using the numbers seen, pick where you would like to place your " + first + ": "); // prompt for player to enter an int
            boardChoice = scan.nextInt(); // setting a variable to the value chosen by the player
            
            if (boardChoice >= 3) { // determining the row of the chosen board spot (1-9)
                for (int x = boardChoice - 1; x >= 3; x -= 3) { // takes the number in board choice and minus by 3 (because there are 3 numbers in each row of the game board)
                    boardRow++;
                }
            }

            System.out.println("You have chosen to place an " + first + " in spot " + boardChoice + " on the game board.");
            
            if (boardChoice % 3 == 0) { // checking to see if boardChoice is a multiple of 3
                stateOfBoard[boardRow][2] = first; // the minus one is needed because i am using (1-9) as opposed to (0-8)
            }
            else {
                stateOfBoard[boardRow][boardChoice%3 - 1] = first;
            }

            if(first.equals("'X'"))
                first = "'O'";
            else
                first = "'X'";
            
            checkGame();

            turnNumber++;
        }

        if (turnNumber > 9)
            System.out.println("It seems this game has ended in a draw.");
            
        System.out.println("This is the final state of the board: "); // final game state

        for (int i = 0; i < stateOfBoard.length; i++)
            System.out.println(Arrays.toString(stateOfBoard[i]));
    }

    public static void checkGame() {
        String hold = "";
        for (int i = 0; i < stateOfBoard.length; i++) { // checks if any row holds the same String (meaning the game is over)
            hold = stateOfBoard[i][0];
            if (hold.equals(stateOfBoard[i][1]) && hold.equals(stateOfBoard[i][2])) {
                System.out.println("Player " + hold + " has won the game!");
                stateOfBoard[i][0] += "!"; // adding exclamation points to better indicate where the game winning combination is
                stateOfBoard[i][1] += "!";
                stateOfBoard[i][2] += "!";
                gameEnd = true;
            }
        }
        for (int j = 0; j < stateOfBoard[0].length; j++) { // checks if any column holds the same String (meaning the game is over)
            hold = stateOfBoard[0][j];
            if (hold.equals(stateOfBoard[1][j]) && hold.equals(stateOfBoard[2][j])) {
                System.out.println("Player " + hold + " has won the game!");
                stateOfBoard[0][j] += "!";
                stateOfBoard[1][j] += "!";
                stateOfBoard[2][j] += "!";
                gameEnd = true;
            }
        }

        hold = stateOfBoard[0][0]; // setting equal to top left value
        if (hold.equals(stateOfBoard[1][1]) && hold.equals(stateOfBoard[2][2])) { // checking the diag from top left to bot right
            System.out.println("Player " + hold + " has won the game!");
            stateOfBoard[0][0] += "!"; // adding exclamation points to better indicate where the game winning combination is
            stateOfBoard[1][1] += "!";
            stateOfBoard[2][2] += "!";
            gameEnd = true;
        }

        hold = stateOfBoard[0][2]; // setting equal to bot left value
        if (hold.equals(stateOfBoard[1][1]) && hold.equals(stateOfBoard[2][0])) { // checking the diag from bot left to top right
            System.out.println("Player " + hold + " has won the game!");
            stateOfBoard[0][2] += "!"; // adding exclamation points to better indicate where the game winning combination is
            stateOfBoard[1][1] += "!";
            stateOfBoard[2][0] += "!";
            gameEnd = true;
        }
    }

    public static void clearBoard() {
        stateOfBoard[0][0] = "1";
        stateOfBoard[0][1] = "2";
        stateOfBoard[0][2] = "3";
        stateOfBoard[1][0] = "4";
        stateOfBoard[1][1] = "5";
        stateOfBoard[1][2] = "6";
        stateOfBoard[2][0] = "7";
        stateOfBoard[2][1] = "8";
        stateOfBoard[2][2] = "9";
    }

    public static void main(String[] args) {
        int gameStart = 0;
        System.out.print("Would you like to play some Tic-Tac-Toe? If so, type 1. ");
        gameStart = scan.nextInt();

        while (gameStart == 1) {
        play();
        
            
        System.out.print("Great game! Would you like to play again? ");
        gameStart = scan.nextInt();
        
        clearBoard();
        gameEnd = false;
        turnNumber = 1;
        }
    }
}
