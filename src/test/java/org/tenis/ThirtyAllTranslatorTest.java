package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirtyAllTranslatorTest {

    static Stream<Arguments> thirtyAllProvider() {
        return Stream.of(
                Arguments.of(2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("thirtyAllProvider")
    void testBothPlayersScoreOnce_ShouldBeThirtyAll(int player1Score, int player2Score) {
        //Arrange
        ThirtyAllTranslator translator = new ThirtyAllTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Thirty-Thirty", result);
    }


}
