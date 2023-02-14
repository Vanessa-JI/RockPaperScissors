import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class Main {

    public static int[] playGame(int[] scores) {

        // define a dictionary for the computer's moves
        HashMap<Integer, String> compMoveMap = new HashMap<Integer, String>();
        compMoveMap.put(1, "rock");
        compMoveMap.put(2, "paper");
        compMoveMap.put(3, "scissors");

        // ask user for input -- get their first move
        System.out.println("Pick your move!");
        System.out.println("1: Rock");
        System.out.println("2: Paper");
        System.out.println("3: Scissors \n");
        Scanner input = new Scanner(System.in);

        int userMove = input.nextInt();
        // let computer randomly generate rock, paper, or scissors
        Random rand = new Random();
        int maxValue = 2;
        int compMove = rand.nextInt(maxValue) + 1; // adding 1 because the range is from 0 to maxValue

        // check if user has won, lost, or drawn
        // increment win, loss, draw score appropriately

        if ((userMove == 1 && compMove == 3) || (userMove == 2 && compMove == 1) || (userMove == 3 && compMove == 2)) {
            scores[0] += 1;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". You won! \n");
        } else if ((userMove == 1 && compMove == 2) || (userMove == 2 && compMove == 3) || (userMove == 3 && compMove == 1)) {
            scores[1] += 1;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". You lost! \n");
        } else if (userMove == compMove) {
            scores[2] += 1;
            System.out.println("The computer chose " + compMoveMap.get(compMove) + ". It's a draw! \n");
        }

        return scores;

    }

    public static void main(String[] args) {

        int[] scores = {0, 0, 0}; //first value is wins, second is losses, third is draws
//        int userWins = 0;
//        int userLosses = 0;
//        int userDraws = 0;

        // ask user for input -- find out how many rounds to play
        System.out.println("How many rounds would you like to play? ");
        Scanner input = new Scanner(System.in);
        int rounds = input.nextInt();

        // check if the number of rounds is in bounds
        // if chosen number of rounds is out of bounds, exit program
        if (rounds < 1 || rounds > 10)  {
            System.out.println("Error -- number of rounds is out of bounds. Please choose a number between 1 and 10.");
            return;
        }

        // if chosen number of rounds is in bounds, play the game the specified number of times
        for (int i = 0; i < rounds; i++) {

            scores = playGame(scores);

        }

        // when number of rounds has been completed, show score
        System.out.println("Your stats: ");
        System.out.println("Wins: " + scores[0]);
        System.out.println("Losses: " + scores[1]);
        System.out.println("Draws: " + scores[2] + "\n");

        // calculate whether the user has won
        if (scores[0] > scores[1] && scores[0] > scores[2]) {
            System.out.println("Congratulations! You beat the computer.");
        } else if (scores[1] > scores[0] && scores[1] > scores[2]) {
            System.out.println("You lost! Try again next time.");
        } else if ((scores[2] > scores[1] && scores[2] > scores[0]) || (scores[0] == scores[1] && scores[0] == scores[2])) {
            System.out.println("Nice! You drew with the computer.");
        } else {
            System.out.println("Nice! You drew with the computer."); // NEED TO FIX THIS FINAL ELSE STATEMENT

        }

        // get user input if they want to continue or end the game
        System.out.println("Would you like to play again?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        Scanner replayInput = new Scanner(System.in);
        int replay = replayInput.nextInt();

        if (replay == 1) {
            main(args);
        }

        // exit game if user selects to exit
        return;

    } // End of main function

} // End of class definition