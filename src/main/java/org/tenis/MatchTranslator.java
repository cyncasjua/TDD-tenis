package org.tenis;

public class MatchTranslator implements IScoreTranslator {

    @Override
    public boolean applies(int player1Sets, int player2Sets) {
        return player1Sets >= 2 || player2Sets >= 2;
    }

    @Override
    public String translate(int player1Sets, int player2Sets) {
        if (!applies(player1Sets, player2Sets)) {
            throw new IllegalArgumentException("Any of the players must have at least 2 sets to win the match");
        }

        if (player1Sets >= 2) {
            return "Player 1 wins match";
        } else {
            return "Player 2 wins match";
        }
    }
}