package karel.hudera.rnma.presentation;

import karel.hudera.rnma.logic.game.IGame;
import karel.hudera.rnma.strings.StringResources;

import java.text.Normalizer;
import java.util.Scanner;

/**
 * Handles user input for the game, including reading input from the console,
 * processing commands, and displaying game messages.
 *
 * @author KarelHudera
 */
public class InputHandler {
    private IGame game;

    /**
     * Constructs an InputHandler with the given game instance.
     *
     * @param game the game instance to interact with
     */
    public InputHandler(IGame game) {
        this.game = game;
    }

    /**
     * Starts the game loop, displaying the introduction message, reading user input,
     * and handling commands until the game is over. Finally, displays the outro message.
     */
    public void play() {
        System.out.println(game.getIntro());

        while (!game.gameOver()) {
            String input = readInput();
            System.out.println(game.handleInput(stripAccents(input.toLowerCase())));
        }

        System.out.print(game.getOutro());
    }

    /**
     * Reads a line of input from the user.
     *
     * @return the user input as a string
     */
    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(StringResources.GameOut.OUTPUT_CHARACTER);
        return scanner.nextLine();
    }

    /**
     * Strips accents from the given string to normalize input for processing.
     *
     * @param s the string to be normalized
     * @return the normalized string without accents
     */
    private String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        return s;
    }
}