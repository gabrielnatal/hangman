package io.github.gabrielnatal.hangman;

import io.github.gabrielnatal.hangman.exception.GameIsFinishedException;
import io.github.gabrielnatal.hangman.exception.LetterAlreadyInputtedException;
import io.github.gabrielnatal.hangman.model.HangmanChar;
import io.github.gabrielnatal.hangman.model.HangmanGame;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

 private static final Scanner scanner = new Scanner(System.in);

 public static void main(String... args) {

       var characters = Stream.of(args)
               .map(a -> a.toLowerCase().charAt(0))
               .map(HangmanChar::new).toList();
        System.out.println(characters);
        var hangmanGame = new HangmanGame(characters);
        System.out.println("Bem-vindo ao jogo da forca! Tente adivinhar a palavra!");
        System.out.println(hangmanGame);

    var option = -1;

    while(true) {
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Informar uma letra");
        System.out.println("2 - Verificar o status do jogo");
        System.out.println("3 - Sair do jogo");
        option = scanner.nextInt();
        switch(option){
            case 1 -> inputCharacter(hangmanGame);
            case 2 -> showGameStatus(hangmanGame);
            case 3 -> System.exit(0);
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
     }
    }

    private static void showGameStatus(HangmanGame hangmanGame) {
        System.out.println(hangmanGame.getHangmanGameStatus());
        System.out.println(hangmanGame);
    }

    private static void inputCharacter( HangmanGame hangmanGame) {
            System.out.println("Informe uma letra: ");
            var character = scanner.next().toLowerCase().charAt(0);
            try{
                hangmanGame.inputCharacter(character);
            }catch (LetterAlreadyInputtedException ex){
                System.out.println(ex.getMessage());
            }
            catch (GameIsFinishedException ex){
                System.out.println(ex.getMessage());
                System.exit(0);
            }
            System.out.println(hangmanGame);
        }

    }

