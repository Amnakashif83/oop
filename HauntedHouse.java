/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hauntedhouse;

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class HauntedHouse{
    public static void main(String[] args) {
        // Array to store the mystery words
        String[] mysteryWords = {"GHOST", "VAMPIRE", "ZOMBIE"};
        Scanner scanner = new Scanner(System.in);
        boolean[] guessedCorrectly = new boolean[mysteryWords.length]; // Track which words have been guessed

        System.out.println("Welcome to the Haunted House Escape Game!");
        System.out.println("You need to guess the mystery word in each room to escape.");

        // Loop through each room
        for (int i = 0; i < mysteryWords.length; i++) {
            String mysteryWord = mysteryWords[i];
            String hint = mysteryWord.substring(0, 1); // First letter as a hint
            String userGuess;

            System.out.println("\nYou are in Room " + (i + 1) + ".");
            System.out.println("Hint: The word starts with '" + hint + "'.");

            // Keep asking for guesses until the correct word is entered
            do {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextLine().toUpperCase(); // Convert input to uppercase

                if (userGuess.equals(mysteryWord)) {
                    System.out.println("Correct! You have unlocked the door to the next room.");
                    guessedCorrectly[i] = true; // Mark this word as guessed correctly
                } else {
                    System.out.println("Incorrect! Try again.");
                }
            } while (!guessedCorrectly[i]); // Repeat until the correct word is guessed
        }

        // Check if all words have been guessed correctly
        boolean allGuessed = true;
        for (boolean guessed : guessedCorrectly) {
            if (!guessed) {
                allGuessed = false;
                break;
            }
        }

        // Display the win message if all words are guessed correctly
        if (allGuessed) {
            System.out.println("\nCongratulations! You have escaped the haunted house!");
        }

        scanner.close();
    }
}
