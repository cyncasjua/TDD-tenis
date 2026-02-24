package org.tenis.basicCases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FifteenFortyTranslatorTest {

    static Stream<Arguments> fifteenFortyProvider() {
        return Stream.of(
                Arguments.of(1, 3)
        );
    }

    static Stream<Arguments> fortyFifteenProvider() {
        return Stream.of(
                Arguments.of(3, 1)
        );
    }

    static Stream<Arguments> notFifteenFortyProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(3, 3),

                Arguments.of(1, 0),
                Arguments.of(1, 2),
                Arguments.of(0, 1),
                Arguments.of(2, 1),

                Arguments.of(3, 0),
                Arguments.of(3, 2),
                Arguments.of(0, 3),
                Arguments.of(2, 3),
                Arguments.of(20, 19)
        );
    }

    @ParameterizedTest
    @MethodSource("fifteenFortyProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenForty(int player1Score, int player2Score) {
        //Arrange
        FifteenFortyTranslator translator = new FifteenFortyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Fifteen-Forty", result);
    }

    @ParameterizedTest
    @MethodSource("fortyFifteenProvider")
    void testPlayerTwoScoresOnce_ShouldBeFortyFifteen(int player1Score, int player2Score) {
        //Arrange
        FifteenFortyTranslator translator = new FifteenFortyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Forty-Fifteen", result);
    }

    @ParameterizedTest
    @MethodSource("notFifteenFortyProvider")
    void testNotFifteenForty_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        FifteenFortyTranslator translator = new FifteenFortyTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }

}
