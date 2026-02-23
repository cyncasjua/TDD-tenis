package org.tenis;

public interface IScoreTranslator {

    boolean applies(int player1Score, int player2Score);

    String translate(int player1Score, int player2Score);
}
