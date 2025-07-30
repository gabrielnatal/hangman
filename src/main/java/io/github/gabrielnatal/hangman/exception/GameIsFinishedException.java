package io.github.gabrielnatal.hangman.exception;

public class GameIsFinishedException extends RuntimeException {
    public GameIsFinishedException(String message) {
        super(message);
    }
}
