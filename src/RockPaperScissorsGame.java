import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class RockPaperScissorsGame {

    public static String x = "Welcome to the game!";

    // playRound function: takes in the current score and updates wins, losses, and draws accordingly after one round of rock, paper, scissors
    public static int[] playRound(int[] scores) {
        
        // EDIT TO USE ENUMS 
        // define a hashmap for the computer's moves -- maps a numeric value to the move played by the computer
        HashMap<Integer, String> compMoveMap = new HashMap<Integer, String>();
        compMoveMap.put(1, "rock");
        compMoveMap.put(2, "paper");
        compMoveMap.put(3, "scissors");

        // ask user for input -- get their first move (move is represented by a number)
        System.out.println("Pick your move! \n 1: Rock \n 2: Paper \n 3: Scissors \n");
        Scanner input = new Scanner(System.in);
        int userMove = input.nextInt();

        // let computer randomly generate a move of rock, paper, or scissors
        Random rand = new Random();
        final int MAXVALUE = 3;
        int compMove = rand.nextInt(MAXVALUE) + 1; // adding 1 because the range is from 0 to MAXVALUE and .nextInt() is non-inclusive

        // check if user has won, lost, or drawn
        // increment win, loss, draw score appropriately
        // print a message showing the result of the current round
        if ((userMove == 1 && compMove == 3) || (userMove == 2 && compMove == 1) || (userMove == 3 && compMove == 2)) {
            scores[0]++;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". You won! \n");
        } else if ((userMove == 1 && compMove == 2) || (userMove == 2 && compMove == 3) || (userMove == 3 && compMove == 1)) {
            scores[1]++;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". You lost! \n");
        } else if (userMove == compMove) {
            scores[2]++;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". It's a draw! \n");
        }

        return scores;

    }

    // main function
    public static void main(String[] args) {

        int[] scores = {0, 0, 0}; // first value is wins, second is losses, third is draws

        // ask user for input -- find out how many rounds to play
        System.out.println(RockPaperScissorsGame.x);
        System.out.println("How many rounds would you like to play? ");
        Scanner input = new Scanner(System.in);
        int rounds = input.nextInt();

        // check if the number of rounds is in bounds
        // if chosen number of rounds is out of bounds, exit program
        if (rounds < 1 || rounds > 10)  {
            System.out.println("Error: number of rounds is out of bounds. Please choose a number between 1 and 10.");
            return;
        }

        // if chosen number of rounds is in bounds, play the game the specified number of times
        for (int i = 0; i < rounds; i++) {
            scores = playRound(scores); // updated scores are returned after the game has been played
        }

        // when number of rounds has been completed, show score
        System.out.println("Game over. Your stats: ");
        System.out.println("Wins: " + scores[0] + "\nLosses: " + scores[1] + "\nDraws: " + scores[2] + "\n");

        /* calculate whether the user has won
            conditions for win:
                - number of wins is greater than number of losses AND draws OR
                - number of wins is equal to number of draws AND greater than number of losses
            conditions for loss:
                - number of losses is greater than number of wins AND draws OR
                - number of losses is equal to number of draws AND greater than number of wins
            conditions for draw:
                - number of draws is greater than number of wins AND losses OR
                - number of wins is equal to number of losses
        */
        if ((scores[0] > scores[1] && scores[0] > scores[2]) || (scores[0] == scores[2] && scores[0] > scores[1])) {
            System.out.println("Congratulations! You beat the computer.");
        } else if ((scores[1] > scores[0] && scores[1] > scores[2]) || (scores[1] == scores[2]) && scores[1] > scores[0]) {
            System.out.println("You lost! Try again next time.");
        } else if ((scores[2] > scores[0] && scores[2] > scores[1]) || (scores[0] == scores[1])) {
            System.out.println("Nice! You drew with the computer.");
        }

        // get user input if they want to continue or end the game
        System.out.println("Would you like to play again? \n1: Yes \n2: No");
        Scanner replayInput = new Scanner(System.in);
        int replay = replayInput.nextInt();

        if (replay == 1) {
            // replay the game if the user chooses to replay
            main(args);
        } else {
            // exit game if user selects to exit
            System.out.println("Thanks for playing!");
        }

    } // End of main function

} // End of class definition
