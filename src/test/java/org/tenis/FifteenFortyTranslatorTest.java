package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
