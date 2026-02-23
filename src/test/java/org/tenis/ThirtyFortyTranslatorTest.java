package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
