import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");
        
        while (true) {
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < number) {
                System.out.println("Too low! Try again:");
            } else if (guess > number) {
                System.out.println("Too high! Try again:");
            } else {
                System.out.printf("Correct! You took %d attempts.%n", attempts);
                break;
            }
        }
        scanner.close();
    }
}