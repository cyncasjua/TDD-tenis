package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScoreTranslatorTest {

    static Stream<TestCase> testCasesProvider() {
        return Stream.of(
                new TestCase(0, 0, "Love-Love"),
                new TestCase(1, 0, "Fifteen-Love"),
                new TestCase(2, 0, "Thirty-Love"),
                new TestCase(3, 0, "Forty-Love"),

                new TestCase(0, 1, "Love-Fifteen"),
                new TestCase(0, 2, "Love-Thirty"),
                new TestCase(0, 3, "Love-Forty"),

                new TestCase(1, 1, "Fifteen-Fifteen"),
                new TestCase(2, 2, "Thirty-Thirty"),
                new TestCase(2, 1, "Thirty-Fifteen"),
                new TestCase(1, 3, "Fifteen-Forty"),

                new TestCase(3, 3, "Deuce"),
                new TestCase(4, 3, "Advantage Player 1"),
                new TestCase(3, 4, "Advantage Player 2"),
                new TestCase(5, 3, "Player 1 wins"),
                new TestCase(3, 5, "Player 2 wins")
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesProvider")
    void should_return_expected_score_when_translated(TestCase testCase) {
        // Arrange
        GameScoreTranslator translator = new GameScoreTranslator();

        // Act
        String result = translator.translate(testCase.player1Score, testCase.player2Score);

        // Assert
        assertEquals(testCase.expectedResult, result);
    }

    static class TestCase {
        int player1Score;
        int player2Score;
        String expectedResult;

        TestCase(int player1Score, int player2Score, String expectedResult) {
            this.player1Score = player1Score;
            this.player2Score = player2Score;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {
            return String.format("Score %d-%d should return \"%s\"", player1Score, player2Score, expectedResult);
        }
    }
}