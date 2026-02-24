package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetTranslatorTest {

    static Stream<Arguments> setWinPlayer1Provider() {
        return Stream.of(
                Arguments.of(4, 0),
                Arguments.of(4, 1),
                Arguments.of(4, 2),
                Arguments.of(5, 3),
                Arguments.of(7, 5),
                Arguments.of(20, 18)
        );
    }

    static Stream<Arguments> setWinPlayer2Provider() {
        return Stream.of(
                Arguments.of(0, 4),
                Arguments.of(1, 4),
                Arguments.of(2, 4),
                Arguments.of(3, 5),
                Arguments.of(5, 7),
                Arguments.of(18, 20)
        );
    }

    static Stream<Arguments> setDeuceProvider() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(5, 5),
                Arguments.of(20, 20)
        );
    }

    static Stream<Arguments> setAdvantagePlayer1Provider() {
        return Stream.of(
                Arguments.of(4, 3),
                Arguments.of(5, 4),
                Arguments.of(20, 19)
        );
    }

    static Stream<Arguments> setAdvantagePlayer2Provider() {
        return Stream.of(
                Arguments.of(3, 4),
                Arguments.of(4, 5),
                Arguments.of(19, 20)
        );
    }

    static Stream<Arguments> setInProgressProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 2),
                Arguments.of(3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("setWinPlayer1Provider")
    void testReturnPlayer1WinsSet(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Player 1 wins set", result);
    }

    @ParameterizedTest
    @MethodSource("setWinPlayer2Provider")
    void testReturnPlayer2WinsSet(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Player 2 wins set", result);
    }

    @ParameterizedTest
    @MethodSource("setDeuceProvider")
    void testReturnDeuceSet(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Deuce set", result);
    }

    @ParameterizedTest
    @MethodSource("setAdvantagePlayer1Provider")
    void testReturnAdvantagePlayer1Set(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Advantage Player 1 set", result);
    }

    @ParameterizedTest
    @MethodSource("setAdvantagePlayer2Provider")
    void testReturnAdvantagePlayer2Set(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Advantage Player 2 set", result);
    }

    @ParameterizedTest
    @MethodSource("setInProgressProvider")
    void testSetIsStillInProgress(int player1Games, int player2Games) {
        //Arrange
        SetTranslator translator = new SetTranslator();

        //Act
        String result = translator.translate(player1Games, player2Games);

        //Assert
        assertEquals("Set in progress", result);
    }
}