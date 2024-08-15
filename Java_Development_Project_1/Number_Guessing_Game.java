import java.util.Random;
import java.util.Scanner;

public class Number_Guessing_Game {

    private static final int MAX_TRIES = 10;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = generateRandomNumber(rand);
            int remainingTries = MAX_TRIES;
            boolean isGuessedCorrectly = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.printf("Guess the number between %d and %d.%n", MIN_VALUE, MAX_VALUE);

            while (remainingTries > 0 && !isGuessedCorrectly) {
                System.out.printf("You have %d guesses left. Make your guess: ", remainingTries);
                
                int guess = getValidatedInput(scanner);
                remainingTries--;

                if (guess == secretNumber) {
                    isGuessedCorrectly = true;
                    System.out.println("Congratulations! You Guessed the Right Number.");
                } else if (guess < secretNumber) {
                    System.out.println("The number is higher. Try again!");
                } else {
                    System.out.println("The number is lower. Try again!");
                }
            }

            if (!isGuessedCorrectly) {
                System.out.printf("Out of attempts! The correct number was: %d%n", secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next().trim().toLowerCase();
            playAgain = userResponse.equals("yes");
        }

        System.out.println("Thanks for playing! See you next time.");
        scanner.close();
    }

    private static int generateRandomNumber(Random rand) {
        return rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }

    private static int getValidatedInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
