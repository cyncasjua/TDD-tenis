package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortyLoveTranslatorTest {

    static Stream<Arguments> fortyLoveProvider() {
        return Stream.of(
                Arguments.of(3, 0)
        );
    }

    static Stream<Arguments> loveFortyProvider() {
        return Stream.of(
                Arguments.of(0, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("fortyLoveProvider")
    void testPlayerOneScoresTwice_ShouldBeFortyLove(int player1Score, int player2Score) {
        //Arrange
        FortyLoveTranslator translator = new FortyLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Forty-Love", result);
    }

    @ParameterizedTest
    @MethodSource("loveFortyProvider")
    void testPlayerTwoScoresTwice_ShouldBeLoveForty(int player1Score, int player2Score) {
        //Arrange
        FortyLoveTranslator translator = new FortyLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Love-Forty", result);
    }


}
