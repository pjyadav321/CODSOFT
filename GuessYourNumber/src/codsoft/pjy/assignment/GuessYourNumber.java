package codsoft.pjy.assignment;

import java.util.Random;
import java.util.Scanner;

/*
 * Simple java class to generate a random number within specified range.
 * Prompt the user to enter their guess for the generated number.
 * Compare the user's guess with the generated number and provide feedback on whether the guess
 is correct, too high, or too low.
 * Repeat steps 2 and 3 until the user guesses the correct number.
 * Limit the number of attempts the user has to guess the number.
 *  Limit the number of attempts the user has to guess the number.
 *  Display the user's score, which can be based on the number of attempts taken or rounds won.
 */
public class GuessYourNumber
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 4;
        boolean playAgain = true;
        int score = 0;

        while (playAgain)
        {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 1;
            boolean guessedCorrectly = false;

            System.out.println("A new number has been generated! Try to guess it.");

            while (attempts <= maxAttempts && !guessedCorrectly)
            {
                System.out.print("Enter your guess (" + min + " to " + max + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess)
                {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1; // Score based on the number of attempts taken
                }
                else if (userGuess < numberToGuess)
                {
                    System.out.println("Your guess is too low. Try again.");
                }
                else
                {
                    System.out.println("Your guess is too high. Try again.");
                }
            }
            if (!guessedCorrectly)
            {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + score);
        scanner.close();
    }

}



