package org.tenis;

public class DeuceTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Score, int player2Score) {
        return player1Score >= 3 && player1Score == player2Score;
    }

    @Override
    public String translate(int player1Score, int player2Score) {
        if (!applies(player1Score, player2Score)) {
            throw new IllegalArgumentException("Deuce is only applicable when both players have at least 3 points and the same score.");
        }
        return "Deuce";
    }
}