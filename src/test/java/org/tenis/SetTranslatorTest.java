package org.tenis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @ParameterizedTest
    @MethodSource("setWinPlayer1Provider")
    void shouldReturnPlayer1WinsSet(int player1Games, int player2Games) {
        SetTranslator translator = new SetTranslator();
        assertEquals("Player 1 wins set", translator.translate(player1Games, player2Games));
    }

    @ParameterizedTest
    @MethodSource("setWinPlayer2Provider")
    void shouldReturnPlayer2WinsSet(int player1Games, int player2Games) {
        SetTranslator translator = new SetTranslator();
        assertEquals("Player 2 wins set", translator.translate(player1Games, player2Games));
    }

    @ParameterizedTest
    @MethodSource("setDeuceProvider")
    void shouldReturnDeuceSet_whenTiedAtFourOrMore(int player1Games, int player2Games) {
        SetTranslator translator = new SetTranslator();
        assertEquals("Deuce set", translator.translate(player1Games, player2Games));
    }

    @ParameterizedTest
    @MethodSource("setAdvantagePlayer1Provider")
    void shouldReturnAdvantagePlayer1Set_whenOneGameAheadAfterThree(int player1Games, int player2Games) {
        SetTranslator translator = new SetTranslator();
        assertEquals("Advantage Player 1 set", translator.translate(player1Games, player2Games));
    }

    @ParameterizedTest
    @MethodSource("setAdvantagePlayer2Provider")
    void shouldReturnAdvantagePlayer2Set_whenOneGameAheadAfterThree(int player1Games, int player2Games) {
        SetTranslator translator = new SetTranslator();
        assertEquals("Advantage Player 2 set", translator.translate(player1Games, player2Games));
    }
}