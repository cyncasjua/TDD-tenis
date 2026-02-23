package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenAllTranslatorTest {

    static Stream<Arguments> fifteenAllProvider() {
        return Stream.of(
                Arguments.of(1, 1)
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


}
