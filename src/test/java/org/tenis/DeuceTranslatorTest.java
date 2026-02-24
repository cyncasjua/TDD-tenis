package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeuceTranslatorTest {

    static Stream<Arguments> deuceProvider() {
        return Stream.of(
                Arguments.of(3, 3)
        );
    }

    static Stream<Arguments> advantageLostProvider() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(5, 5),
                Arguments.of(20, 20)
        );
    }

    static Stream<Arguments> notDeuceProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),

                Arguments.of(1, 0),
                Arguments.of(0, 2),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(3, 5),
                Arguments.of(5, 4),
                Arguments.of(20, 19)
        );
    }

    @ParameterizedTest
    @MethodSource("deuceProvider")
    void testScoreIsFortyAll_ShouldBeDeuce(int player1Score, int player2Score) {
        //Arrange
        DeuceTranslator translator = new DeuceTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Deuce", result);
    }

    @ParameterizedTest
    @MethodSource("advantageLostProvider")
    void testAdvantageLost_BackToDeuce(int player1Score, int player2Score) {
        //Arrange
        DeuceTranslator translator = new DeuceTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Deuce", result);
    }

    @ParameterizedTest
    @MethodSource("notDeuceProvider")
    void testNotDeuce_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        DeuceTranslator translator = new DeuceTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }


}
