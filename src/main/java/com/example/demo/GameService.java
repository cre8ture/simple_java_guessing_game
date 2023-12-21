package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private int secretNumber;

    public GameService() {
        this.secretNumber = new Random().nextInt(100) + 1;
    }

    public String checkGuess(int guess) {
        if (guess == secretNumber) {
            return "Congratulations! You've guessed the secret number.";
        } else if (guess < secretNumber) {
            return "Too low! Try a higher number.";
        } else {
            return "Too high! Try a lower number.";
        }
    }
}