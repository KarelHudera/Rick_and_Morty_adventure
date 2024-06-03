package karel.hudera.rnma.presentation;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.IGame;

import java.text.Normalizer;
import java.util.Scanner;

public class InputHandler {
    private IGame game;

    public InputHandler(IGame game) {
        this.game = game;
    }

    public void play() {
        System.out.println(game.getIntro());

        while (!game.gameOver()) {
            String input = readInput();
//            String test = stripAccents(radek.toLowerCase());
            System.out.println(game.handleInput(stripAccents(input.toLowerCase())));
        }

        System.out.print(game.getOutro());
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(StringResources.GameOut.OUTPUT_CHARACTER);
        return scanner.nextLine();
    }

    private String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        return s;
    }
}