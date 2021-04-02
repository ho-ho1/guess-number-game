package com.rudzki.adam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 100;
    private final List<Integer> history = new ArrayList<>();

    Scanner in = new Scanner(System.in);
    int secretNumber = random.nextInt(MAX_NUMBER) + 1;

    public static void main(String[] args) {
        new GuessGame().run();
    }

    public void run() {

        boolean isWinner = false;

        System.out.printf("Please guess a number between 1 and %d %n", MAX_NUMBER);
        while (!isWinner) {

            System.out.print("Your guess: ");
            String userInput = in.next();
            int userNumber = Integer.parseInt(userInput); //TODO: Additional verification necessary

            history.add(userNumber);
            System.out.println(answerFor(userNumber));

            isWinner = userNumber == secretNumber;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.printf("Attempt #%d: %d - %s %n", i + 1, history.get(i), answerFor(history.get(i)));
        }
    }

    private String answerFor(int userNumber) {
        if (userNumber == secretNumber) {
            return "Correct.";
        } else if (userNumber > secretNumber) {
            return "Too high.";
        } else {
            return "Too low.";
        }
    }

}
