package karel.hudera.rnma.logic.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        // Initialize the Game instance before each test
        game = new Game();
    }

    @Test
    void getIntro() {
        // Assuming getIntro() returns a string representing the introduction of the game
        String expectedIntro = "Welcome to the game!";
        assertEquals(expectedIntro, game.getIntro(), "Intro text should be correctly returned");
    }

    @Test
    void getOutro() {
        // Assuming getOutro() returns a string representing the conclusion of the game
        String expectedOutro = "Game over. Thank you for playing!";
        assertEquals(expectedOutro, game.getOutro(), "Outro text should be correctly returned");
    }

    @Test
    void gameOver() {
        // Assuming gameOver() returns true if the game is over
        game.setGameOver(true);
        assertTrue(game.gameOver(), "gameOver should return true when game is set as over");
    }

    @Test
    void setGameOver() {
        // Assuming setGameOver(boolean status) sets the game over status
        game.setGameOver(false);
        assertFalse(game.gameOver(), "gameOver should return false when game is not over");
    }
}