import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
/*

A number-guessing game.

*/

public class Game {
  public static void main(String[] args){
    // Put your code here
    System.out.println("Welcome to the guessing game!");
  
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your name:");
    String name = input.nextLine();
    System.out.println(name + ", I'm thinking of a number between 0 and 100.");
    
    Random rand = new Random();
    int number = rand.nextInt(101);

    System.out.println("secret number:" + number);


    int guessCount = 0;

    boolean keepPlaying = true; 
    boolean gameEnded= false;
    int maxGuess = 5; 

    do {
      try {
        gameEnded = false;
        System.out.println("Make guess. You have guessed " + guessCount + " times. You have a total of " + maxGuess + " tries.");
        int guess = input.nextInt();
        guessCount++;
        if (guessCount < maxGuess) {
          if (guess > number) {
            if (guess > 100){
              System.out.println("Integer out of range. Please enter number less than 100.");
            } else {
              System.out.println("Guess again - try a lower number.");
            }
          }
          else if (guess < number) {
            if (guess < 0) {
              System.out.println("Integer out of range. Please enter number greater than 0.");
            } else {
              System.out.println("Guess again - try a higher number.");
            }
          }
          else {
            System.out.println("That's right! You made the correct guess. ");
            System.out.println("It took you " + guessCount + " guesses. Great job!");
            gameEnded = true;
          }
        }

        else {
          System.out.println("That's too many guesses. Game over.");
          gameEnded = true;
        }

        if (gameEnded == true) {
  
          System.out.println("Would you like to play again? Answer y/n:");

          Scanner playAgainInput = new Scanner(System.in);
          String playAgain = playAgainInput.nextLine();
          playAgain = playAgain.toLowerCase();

          if (playAgain.equals("n") || playAgain.equals("no")){
            System.out.println("I don't wanna play anymore.");
            keepPlaying = false;
          } 
          else {
            number = rand.nextInt(101);
            System.out.println("secret number:" + number);
            guessCount = 0;
          }
        }

      } catch (InputMismatchException e) {
        String badInput = input.next();
        System.out.println(badInput + " is not a valid integer. Try again.");
        continue;
      }


    } while (keepPlaying == true);

    // System.out.println("That's right! You made the correct guess. ");
    // System.out.println("It took you " + guessCount + " guesses. Great job!");


  
  }

}
