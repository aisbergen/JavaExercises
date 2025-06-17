import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;

        
        while ((n = in.nextInt()) != 0) { // Read n, if it's 0, terminate the program.

            // Inner loop to process permutations for the current 'n'.
            // Each permutation line starts with a number, then the rest of the permutation,
            // or '0' if it's the end of permutations for this 'n'.
            while (true) {
                // Read the first number of the permutation line.
                int firstCoachInPermutation = in.nextInt();

                // If it's '0', it means we're done with permutations for the current 'n'.
                if (firstCoachInPermutation == 0) {
                    System.out.println(); // Print empty line after each block of permutations (as per example output)
                    break; // Exit this inner loop, go back to read the next 'n'
                }

                // If it's not '0', it's the start of a new target permutation.
                int[] targetOrder = new int[n]; // Array to store the target permutation
                targetOrder[0] = firstCoachInPermutation; // The first number is already read

                // Read the remaining n-1 numbers for the current target permutation
                for (int i = 1; i < n; i++) {
                    targetOrder[i] = in.nextInt();
                }

                // --- Core Logic for Stack Permutation Check ---
                Stack<Integer> station = new Stack<>(); // Represents the railway station track

                int currentCoachExpectedFromA = 1; // Coaches arrive from A starting with 1
                int targetIdx = 0;                 // Index to track which coach we need next from the targetOrder

                boolean possible = true;           // Flag to determine if the permutation is possible

                // Iterate through the desired output order (targetOrder)
                while (targetIdx < n) {
                    int requiredCoach = targetOrder[targetIdx]; // The coach we want to output next

                    if (requiredCoach == currentCoachExpectedFromA) {
                        // Case 1: The required coach is the next one arriving directly from A.
                        // Take it directly from A.
                        currentCoachExpectedFromA++;
                        targetIdx++;
                    } else if (requiredCoach > currentCoachExpectedFromA) {
                        // Case 2: The required coach has not yet arrived from A,
                        // AND we need to push smaller coaches (from A) into the station
                        // until requiredCoach arrives.
                        while (currentCoachExpectedFromA < requiredCoach) {
                            station.push(currentCoachExpectedFromA); // Shunt to station
                            currentCoachExpectedFromA++;
                        }
                        // Now currentCoachExpectedFromA == requiredCoach. Take it directly from A.
                        currentCoachExpectedFromA++;
                        targetIdx++;
                    } else { // requiredCoach < currentCoachExpectedFromA
                        // Case 3: The required coach has already passed from A.
                        // It MUST be at the top of the station stack.
                        if (station.isEmpty() || station.peek() != requiredCoach) {
                            // If station is empty or the top coach isn't what we need, it's impossible.
                            possible = false;
                            break; // Stop processing this permutation early, it's impossible.
                        } else {
                            // The required coach is at the top of the station stack. Take it.
                            station.pop();
                            targetIdx++;
                        }
                    }
                }

                // --- Output the result for the current permutation ONLY AFTER the entire check ---
                if (possible) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            } // End of inner while loop (for permutations within a block)

        } // End of outer while loop (for blocks of N)

        in.close(); // Close the scanner when done reading all input
    }
}
