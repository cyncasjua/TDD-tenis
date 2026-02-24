package org.tenis.basicCases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThirtyFortyTranslatorTest {

    static Stream<Arguments> thirtyFortyProvider() {
        return Stream.of(
                Arguments.of(2, 3)
        );
    }

    static Stream<Arguments> fortyThirtyProvider() {
        return Stream.of(
                Arguments.of(3, 2)
        );
    }

    static Stream<Arguments> notThirtyFortyProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),

                Arguments.of(2, 0),
                Arguments.of(2, 1),
                Arguments.of(0, 2),
                Arguments.of(1, 2),

                Arguments.of(3, 0),
                Arguments.of(3, 1),
                Arguments.of(0, 3),
                Arguments.of(1, 3),
                Arguments.of(19, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("thirtyFortyProvider")
    void testPlayerOneScoresOnce_ShouldBeThirtyForty(int player1Score, int player2Score) {
        //Arrange
        ThirtyFortyTranslator translator = new ThirtyFortyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Thirty-Forty", result);
    }

    @ParameterizedTest
    @MethodSource("fortyThirtyProvider")
    void testPlayerTwoScoresOnce_ShouldBeFortyThirty(int player1Score, int player2Score) {
        //Arrange
        ThirtyFortyTranslator translator = new ThirtyFortyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Forty-Thirty", result);
    }

    @ParameterizedTest
    @MethodSource("notThirtyFortyProvider")
    void testNotThirtyForty_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        ThirtyFortyTranslator translator = new ThirtyFortyTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }

}
