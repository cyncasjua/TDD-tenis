package org.tenis.basicCases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FifteenAllTranslatorTest {

    static Stream<Arguments> fifteenAllProvider() {
        return Stream.of(
                Arguments.of(1, 1)
        );
    }

    static Stream<Arguments> notFifteenAllProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4),

                Arguments.of(1, 0),
                Arguments.of(0, 1),
                Arguments.of(2, 1),
                Arguments.of(1, 2),
                Arguments.of(20, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("fifteenAllProvider")
    void testBothPlayersScoreOnce_ShouldBeFifteenAll(int player1Score, int player2Score) {
        //Arrange
        FifteenAllTranslator translator = new FifteenAllTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Fifteen-Fifteen", result);
    }

    @ParameterizedTest
    @MethodSource("notFifteenAllProvider")
    void testNotFifteenAll_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        FifteenAllTranslator translator = new FifteenAllTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }

}
