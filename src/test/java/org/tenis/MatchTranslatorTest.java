package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTranslatorTest {

    static Stream<Arguments> matchWinPlayer1Provider() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(2, 1)
        );
    }

    static Stream<Arguments> matchWinPlayer2Provider() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("matchWinPlayer1Provider")
    void shouldReturnPlayer1WinsMatch_whenReachesTwoSets(int player1Sets, int player2Sets) {
        //Arrange
        MatchTranslator translator = new MatchTranslator();

        //Act
        String result = translator.translate(player1Sets, player2Sets);

        //Assert
        assertEquals("Player 1 wins match", result);
    }

    @ParameterizedTest
    @MethodSource("matchWinPlayer2Provider")
    void shouldReturnPlayer2WinsMatch_whenReachesTwoSets(int player1Sets, int player2Sets) {
        //Arrange
        MatchTranslator translator = new MatchTranslator();

        //Act
        String result = translator.translate(player1Sets, player2Sets);

        //Assert
        assertEquals("Player 2 wins match", result);
    }
}