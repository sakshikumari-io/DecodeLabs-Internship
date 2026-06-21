import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        // The Toolkit: Stream Capture & Stochastic Generation
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain;
        int totalScore = 0; // Optimization: Score Tracking

        System.out.println("=== DecodeLabs: Number Guessing Game ===");

        // Optimization: Session Persistence (do-while loop)
        do {
            // The Zero-Index Shift: Generates 1 to 100
            int target = random.nextInt(100) + 1; 
            boolean win = false;
            int attempts = 0;
            int maxAttempts = 3; // Optimization: Attempt Limiter

            System.out.println("\nEngine Ready: I have generated a random number between 1 and 100.");
            System.out.println("Mission: You have " + maxAttempts + " attempts to deduce it.");

            // The Logic Architecture: Core Game Loop
            while (!win && attempts < maxAttempts) {
                System.out.print("\nEnter guess (" + (maxAttempts - attempts) + " left): ");
                
                try {
                    int guess = scanner.nextInt();
                    attempts++;

                    // Decision Tree
                    if (guess == target) {
                        System.out.println("Correct! Target neutralized in " + attempts + " attempts.");
                        // Higher score for fewer attempts
                        totalScore += (100 - (attempts * 10)); 
                        win = true;
                    } else if (guess > target) {
                        System.out.println("Feedback: Too High");
                    } else {
                        System.out.println("Feedback: Too Low");
                    }

                    // Attempt Limiter check
                    if (!win && attempts == maxAttempts) {
                        System.out.println("\nMission Failed. Out of attempts.");
                        System.out.println("The target number was: " + target);
                    }

                } catch (InputMismatchException e) {
                    // Defensive Engineering: Input Validation
                    System.out.println("Threat Detected: Invalid input. Please enter a whole number.");
                    // Hazard Warning Solution: Flush the scanner buffer to prevent infinite loop
                    scanner.nextLine(); 
                }
            }

            System.out.println("Current Score: " + totalScore);

            // Play Again Prompt
            System.out.print("\nPlay Again? [Y/N]: ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("Y");

        } while (playAgain);
        
        System.out.println("\nSession terminated. Final Score: " + totalScore);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

