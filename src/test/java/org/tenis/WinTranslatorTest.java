package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinTranslatorTest {

    static Stream<Arguments> winPlayer1Provider() {
        return Stream.of(
                Arguments.of(4, 0),
                Arguments.of(4, 1),
                Arguments.of(4, 2)
        );
    }

    static Stream<Arguments> winAfterDeucePlayer1Provider() {
        return Stream.of(
                Arguments.of(5, 3),
                Arguments.of(7, 5),
                Arguments.of(20, 18)
        );
    }

    static Stream<Arguments> winPlayer2Provider() {
        return Stream.of(
                Arguments.of(0, 4),
                Arguments.of(1, 4),
                Arguments.of(2, 4)
                );
    }

    static Stream<Arguments> winAfterDeucePlayer2Provider() {
        return Stream.of(
                Arguments.of(3, 5),
                Arguments.of(5, 7),
                Arguments.of(18, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("winAfterDeucePlayer1Provider")
    void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne(int player1Score, int player2Score) {
        //Arrange
        WinTranslator translator = new WinTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Player 1 wins", result);
    }

    @ParameterizedTest
    @MethodSource("winPlayer1Provider")
    void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne(int player1Score, int player2Score) {
        //Arrange
        WinTranslator translator = new WinTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Player 1 wins", result);
    }

    @ParameterizedTest
    @MethodSource("winAfterDeucePlayer2Provider")
    void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo(int player1Score, int player2Score) {
        //Arrange
        WinTranslator translator = new WinTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Player 2 wins", result);
    }

    @ParameterizedTest
    @MethodSource("winPlayer2Provider")
    void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo(int player1Score, int player2Score) {
        //Arrange
        WinTranslator translator = new WinTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Player 2 wins", result);
    }

}
