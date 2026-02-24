package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThirtyAllTranslatorTest {

    static Stream<Arguments> thirtyAllProvider() {
        return Stream.of(
                Arguments.of(2, 2)
        );
    }

    static Stream<Arguments> notThirtyAllProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(3, 3),
                Arguments.of(4, 4),

                Arguments.of(2, 0),
                Arguments.of(0, 2),
                Arguments.of(2, 1),
                Arguments.of(1, 2),
                Arguments.of(3, 2),
                Arguments.of(2, 3)
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

    @ParameterizedTest
    @MethodSource("notThirtyAllProvider")
    void testNotThirtyAll_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        ThirtyAllTranslator translator = new ThirtyAllTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }


}
