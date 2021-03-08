import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a very simple Tic Tac Toe game that
 * a user can play on the console
 *
 * @author Daniel Rocha
 * @version 1.0
 */

public class TicTacToe {
    static Scanner input;
    static String[] board;
    static String turn;

    public static void main(String[] args) {
        board = new String[9];
        turn = "X";
        String winner = null;
        populateBoard();

        System.out.println("Tic Tac Toe Game");
        System.out.println("Type Help to get a small Tutorial");
        printBoard();
        System.out.println("X's will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;
            try {
                input = new Scanner(System.in);
                numInput = input.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input (must be a number from 1 to 9):");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please re-enter slot number:");
                continue;
            }
            if (board[numInput-1].equals(String.valueOf(numInput))) {
                board[numInput-1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
                if(winner==null) System.out.println(turn + "'s turn. Enter a slot number to place " + turn + " in:");
            } else {
                System.out.println("Slot already taken; Please re-enter slot number:");
                continue;
            }
        }
        if (winner.equals("X")||winner.equals("O")) {
            System.out.println(winner + "'s have won!");
        }
        if(winner.equals("draw")) System.out.println("It's a draw!");
    }

    /**
     * Checks if there is a winner or a draw, and in either
     * case announces it. If the game hasn't ended, it returns null
     * so the while loop can continue.
     *
     * @return the winner, if it's a draw, or null (if neither of the previous)
     */
    static String checkWinner() {
        String line;
        for (int i = 0; i < 8; i++) {
            line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!board[i].equals("X")&&!board[i].equals("O")) return null;
        }
        //only returns draw if all spaces on the board are filled (and a winner has not been declared)
        return "draw";
    }

    /**
     * Prints the help prompt to the console
     */
    static void help() {
        System.out.println("The board system is as follows (Slot Numbers):");
        System.out.println("┌-----------┐");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("|-----------|");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("|-----------|");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("└-----------┘");
    }

    /**
     * Prints the board to the console
     */
    static void printBoard() {
        System.out.println("┌-----------┐");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("└-----------┘");
    }

    /**
     * Populates (fills) the board
     */
    static void populateBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i+1);
        }
    }
}