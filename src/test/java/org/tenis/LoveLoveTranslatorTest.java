package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoveLoveTranslatorTest {

    static Stream<Arguments> loveLoveProvider() {
        return Stream.of(
                Arguments.of(0, 0)
        );
    }

    static Stream<Arguments> notLoveLoveProvider() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(0, 1),
                Arguments.of(2, 0),
                Arguments.of(0, 2),
                Arguments.of(3, 0),
                Arguments.of(0, 3),

                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("loveLoveProvider")
    void shouldReturnLoveLove_OnStart(int player1Score, int player2Score) {
        //Arrange
        LoveLoveTranslator translator = new LoveLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Love-Love", result);
    }

    @ParameterizedTest
    @MethodSource("notLoveLoveProvider")
    void testNotLoveLove_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        LoveLoveTranslator translator = new LoveLoveTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }
}
