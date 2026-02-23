package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvantageTranslatorTest {

    static Stream<Arguments> advantagePlayer1Provider() {
        return Stream.of(
                Arguments.of(4, 3)
        );
    }

    static Stream<Arguments> advantagePlayer2Provider() {
        return Stream.of(
                Arguments.of(3, 4)
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

}
