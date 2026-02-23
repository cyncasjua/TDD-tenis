package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirtyLoveTranslatorTest {

    static Stream<Arguments> thirtyLoveProvider() {
        return Stream.of(
                Arguments.of(2, 0)
        );
    }

    static Stream<Arguments> loveThirtyProvider() {
        return Stream.of(
                Arguments.of(0, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("thirtyLoveProvider")
    void testPlayerOneScoresTwice_ShouldBeThirtyLove(int player1Score, int player2Score) {
        //Arrange
        ThirtyLoveTranslator translator = new ThirtyLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Thirty-Love", result);
    }

    @ParameterizedTest
    @MethodSource("loveThirtyProvider")
    void testPlayerTwoScoresTwice_ShouldBeLoveThirty(int player1Score, int player2Score) {
        //Arrange
        ThirtyLoveTranslator translator = new ThirtyLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Love-Thirty", result);
    }


}
