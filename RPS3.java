/*
 * Name: Jinyang Liu
 * 
 * This program is a simple implementation of the classic game *Rock-Paper-Scissors. It allows a player to play against the computer. 
 * The player first inputs their name, and then selects their throw (Rock, Paper, or Scissors) by entering a corresponding number. 
 * The computer's throw is generated randomly. The program then decides the winner based on the rules of Rock-Paper-Scissors:
 * Rock crushes Scissors, Scissors cuts Paper, and Paper covers Rock. It announces the result of the game, including the player's throw,
 * the computer's throw, and the winner. The game is intended for a single round of play per execution.
 */

import java.util.Random;
import java.util.Scanner;

public class RPS3 {
    private String name;
    private int playerThrow;
    private Scanner input = new Scanner(System.in);

    /*
     * This method can get the name of player and save it
     * 
     * @input none
     * 
     * @return the name of player
     */
    public String getName() {
        System.out.println("What's your name?");

        this.name = input.next();
        System.out.println("Hello, " + this.name + "!");

        return this.name;
    }

    /*
     * This method can get the player throw
     * 
     * @input none
     * 
     * @return the player throw
     */
    public int getPlayerThrow() {
        input = new Scanner(System.in); // 重新实例化Scanner

        while (true) {
            System.out.println("Enter your throw: (Rock, Paper, Scissors): ");

            String playerThrow = input.nextLine();

            if ("Rock".equalsIgnoreCase(playerThrow)) {
                this.playerThrow = 0;
                break;
            } else if ("Paper".equalsIgnoreCase(playerThrow)) {
                this.playerThrow = 1;
                break;
            } else if ("Scissors".equalsIgnoreCase(playerThrow)) {
                this.playerThrow = 2;
                break;
            } else {
                System.out.println("You did not say Rock, Paper or Scissors! No Fair!\n");
            }
        }

        return playerThrow;
    }

    /*
     * This method can print the player throw
     * 
     * @input playerName and throwNumber
     * 
     * @return none
     */
    public void printThrow(String playerName, int throwNumber) {
        System.out.print(playerName + " throws ");
        switch (throwNumber) {
            case 0:
                System.out.println("Rock.");
                break;
            case 1:
                System.out.println("Paper.");
                break;
            case 2:
                System.out.println("Scissors.");
                break;
            default:
                break;
        }
    }

    /*
     * This method can get a random number symbolize computer throw
     * 
     * @input none
     * 
     * @return computer throw
     */
    public int getComputerThrow() {
        Random Throw = new Random();
        int computerThrow = Throw.nextInt(3);
        this.printThrow("Computer", computerThrow);
        return computerThrow;
    }

    /*
     * This method can decide the winner between player and computer
     * 
     * @input computer throw
     * 
     * @return result, 0 means dogfall, 1 means player win, 2 means computer win
     * PS: You must care about priority!!!
     */
    public int decideWinner(int computerThrow) {
        if (this.playerThrow == computerThrow) {
            return 0;
        } else if (playerThrow == 0 && computerThrow == 2) {
            return 1;
        } else if (computerThrow == 0 && playerThrow == 2) {
            return 2;
        } else if (computerThrow > playerThrow) {
            return 2;
        } else if (playerThrow > computerThrow) {
            return 1;
        } else {
            return -1;
        }
    }

    /*
     * This method can print the winner
     * input winner's number
     * return none,
     * PS: Winner's number 0 means dogfall, 1 means player win, 2 means computer win
     */
    public void printWinner(int winner) {
        switch (winner) {
            case 0:
                System.out.println("DogFall!!!\n");
                break;
            case 1:
                System.out.println("Player win!!!\n");
                break;
            case 2:
                System.out.println("Computer win!!!\n\n");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Build a new instance
        RPS3 myRps = new RPS3();

        String yourName = myRps.getName();

        System.out.println("How many times do you want to play the game: ");
        int times = input.nextInt();

        System.out.println("Let's play Rock-Paper-Scissors!");

        for (int i = 0; i < times; i++) {

            // Little skills to make short
            myRps.printThrow(yourName, myRps.getPlayerThrow());
            myRps.printWinner(myRps.decideWinner(myRps.getComputerThrow()));
        }

        System.out.println("Goodbye!!!");

        myRps.input.close();// Prevent overflow!!!
        input.close();
    }
}
