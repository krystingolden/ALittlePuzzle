package com.pluralsight;



public class Main {

    /*
    https://programmingbydoing.com/
    A little puzzle - Assignment #136
     */

    public static void main(String[] args) throws Exception {

        Puzzle puzzle = new Puzzle();
        //Read in a file as entered by the user
        String choice = puzzle.determineFile();
        puzzle.readInChars(choice);

        //print out the hidden message
        puzzle.writeOutPuzzle();
    }
}
