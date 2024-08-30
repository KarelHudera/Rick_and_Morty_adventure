//package karel.hudera.rnma.presentation; TODO
//
//import karel.hudera.rnma.logic.game.IGame;
//import karel.hudera.rnma.strings.StringResources;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class InputHandlerTest {
//
//    private IGame game;
//    private InputHandler inputHandler;
//
//    @BeforeEach
//    void setUp() {
//        game = mock(IGame.class);
//        inputHandler = new InputHandler(game);
//    }
//
//    @Test
//    void play() {
//        // Arrange
//        String introMessage = StringResources.Intro.INTRO_MESSAGE;
//        String outroMessage = StringResources.Outro.OUTRO_MESSAGE;
//        String validInput = "goto kitchen";
//        String response = "Moved to kitchen.";
//
//        when(game.getIntro()).thenReturn(introMessage);
//        when(game.getOutro()).thenReturn(outroMessage);
//        when(game.gameOver()).thenReturn(false, false, true); // Simulate game over after two inputs
//        when(game.handleInput(validInput)).thenReturn(response);
//
//        // Simulate user input
//        String simulatedInput = validInput + System.lineSeparator() + "endgame" + System.lineSeparator();
//        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
//        System.setIn(input);
//
//        // Capture system output
//        PrintStream originalOut = System.out;
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Act
//        inputHandler.play();
//
//        // Assert
//        String output = outputStream.toString().trim();
//        assertTrue(output.contains(introMessage));
//        assertTrue(output.contains(response));
//        assertTrue(output.contains(outroMessage));
//
//        // Restore original System.in and System.out
//        System.setIn(System.in);
//        System.setOut(originalOut);
//    }
//}