package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Puzzle {


    private String puzzle;

    public String determineFile() {
        //Prompt the user for the filename to read from
        System.out.println("Which puzzle do you want to read from?");
        Scanner keyboard = new Scanner(System.in);

        //If the users entry is incorrect, prompt them again
        String choice = keyboard.next();
        while (!(choice.equalsIgnoreCase("puzzle.txt") || choice.equalsIgnoreCase("puzzle2.txt"))) {
            System.out.println("Entry must be \"puzzle.txt\" or \"puzzle2.txt\"");
            System.out.println("Which puzzle do you want to read from?");
            choice = keyboard.next();
        }
        return choice;
    }

    public void readInChars(String choice) throws IOException {

        //Get the path to the file and open it
        try (BufferedReader br = Files.newBufferedReader(Paths.get(choice))) {

            //Add the full contents of the file into the variable
            puzzle = br.readLine();

            //If there is an issue opening the file, it will throw a message
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    //Build a string with every 3rd letter of the puzzle and write it out
    public void writeOutPuzzle() {

        StringBuilder sb = new StringBuilder();
        for (int a = 2; a < puzzle.length(); a = a + 3) {
            char letter = puzzle.charAt(a);
            sb.append(letter);
        }
        String modifiedPuzzle = sb.toString();

        System.out.println(modifiedPuzzle);

    }
}
