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

    @ParameterizedTest
    @MethodSource("loveLoveProvider")
    void should_return_buzz_when_translate_is_called_with_multiple_of_five(int player1Score, int player2Score) {
        //Arrange
        LoveLoveTranslator translator = new LoveLoveTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Love-Love", result);
    }

}
