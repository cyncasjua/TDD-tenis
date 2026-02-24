package org.tenis;

import org.tenis.basicCases.*;

import java.util.Arrays;

public class GameScoreTranslator {

    private final IScoreTranslator[] translators;

    public GameScoreTranslator() {
        translators = new IScoreTranslator[]{
                new WinTranslator(),
                new AdvantageTranslator(),
                new DeuceTranslator(),
                new FortyLoveTranslator(),
                new ThirtyLoveTranslator(),
                new FifteenLoveTranslator(),
                new LoveLoveTranslator(),
                new FifteenAllTranslator(),
                new ThirtyAllTranslator(),
                new FifteenFortyTranslator(),
                new FifteenThirtyTranslator(),
                new ThirtyFortyTranslator(),
        };
    }

    public String translate(int p1Score, int p2Score) {
        return Arrays.stream(translators)
                .filter(t -> t.applies(p1Score, p2Score))
                .findFirst()
                .map(t -> t.translate(p1Score, p2Score))
                .orElse("");
    }

}