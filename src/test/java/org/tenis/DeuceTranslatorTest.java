package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortyAllTranslatorTest {

    static Stream<Arguments> fortyAllProvider() {
        return Stream.of(
                Arguments.of(3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("fortyAllProvider")
    void testBothPlayersScoreOnce_ShouldBeFortyAll(int player1Score, int player2Score) {
        //Arrange
        FortyAllTranslator translator = new FortyAllTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Forty-Forty", result);
    }


}
