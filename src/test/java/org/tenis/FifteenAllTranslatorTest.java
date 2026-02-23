package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenLoveTranslatorTest {

    static Stream<Arguments> fifteenLoveProvider() {
        return Stream.of(
                Arguments.of(1, 0)
        );
    }

    static Stream<Arguments> loveFifteenProvider() {
        return Stream.of(
                Arguments.of(0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("fifteenLoveProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(int player1Score, int player2Score) {
        //Arrange
        FifteenLoveTranslator translator = new FifteenLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Fifteen-Love", result);
    }

    @ParameterizedTest
    @MethodSource("loveFifteenProvider")
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen(int player1Score, int player2Score) {
        //Arrange
        FifteenLoveTranslator translator = new FifteenLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Love-Fifteen", result);
    }

}
