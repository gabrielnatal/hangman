package io.github.gabrielnatal.hangman.exception;

public class LetterAlreadyInputtedException extends RuntimeException {
    public LetterAlreadyInputtedException(String message) {
        super(message);
    }

}
