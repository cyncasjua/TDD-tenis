package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FifteenThirtyTranslatorTest {

    static Stream<Arguments> fifteenThirtyProvider() {
        return Stream.of(
                Arguments.of(1, 2)
        );
    }

    static Stream<Arguments> thirtyFifteenProvider() {
        return Stream.of(
                Arguments.of(2, 1)
        );
    }

    static Stream<Arguments> notFifteenLoveProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),

                Arguments.of(2, 0),
                Arguments.of(3, 0),
                Arguments.of(0, 2),
                Arguments.of(0, 3),

                Arguments.of(1, 2),
                Arguments.of(1, 3),
                Arguments.of(2, 1),
                Arguments.of(3, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("fifteenThirtyProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenThirty(int player1Score, int player2Score) {
        //Arrange
        FifteenThirtyTranslator translator = new FifteenThirtyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Fifteen-Thirty", result);
    }

    @ParameterizedTest
    @MethodSource("thirtyFifteenProvider")
    void testPlayerTwoScoresOnce_ShouldBeThirtyFifteen(int player1Score, int player2Score) {
        //Arrange
        FifteenThirtyTranslator translator = new FifteenThirtyTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Thirty-Fifteen", result);
    }

    @ParameterizedTest
    @MethodSource("notFifteenLoveProvider")
    void testNotFifteenLove_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        FifteenLoveTranslator translator = new FifteenLoveTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }

}
