package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdvantageTranslatorTest {

    static Stream<Arguments> advantagePlayer1Provider() {
        return Stream.of(
                Arguments.of(4, 3),
                Arguments.of(5, 4),
                Arguments.of(20, 19)
        );
    }

    static Stream<Arguments> advantagePlayer2Provider() {
        return Stream.of(
                Arguments.of(3, 4),
                Arguments.of(4, 5),
                Arguments.of(19, 20)
        );
    }

    static Stream<Arguments> notAdvantageProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4),
                Arguments.of(4, 2),
                Arguments.of(3, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("advantagePlayer1Provider")
    void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne(int player1Score, int player2Score) {
        //Arrange
        AdvantageTranslator translator = new AdvantageTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Advantage Player 1", result);
    }

    @ParameterizedTest
    @MethodSource("advantagePlayer2Provider")
    void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo(int player1Score, int player2Score) {
        //Arrange
        AdvantageTranslator translator = new AdvantageTranslator();

        //Act
        String result = translator.translate(player1Score, player2Score);

        //Assert
        assertEquals("Advantage Player 2", result);
    }

    @ParameterizedTest
    @MethodSource("notAdvantageProvider")
    void testNotAdvantage_ShouldThrowException(int player1Score, int player2Score) {
        //Arrange
        AdvantageTranslator translator = new AdvantageTranslator();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            translator.translate(player1Score, player2Score);
        });
    }

}
