package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest
    @MethodSource("fifteenThirtyProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(int player1Score, int player2Score) {
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

}
