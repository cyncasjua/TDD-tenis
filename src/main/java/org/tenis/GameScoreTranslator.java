package org.tenis;

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
        for (IScoreTranslator translator : translators) {
            if (translator.applies(p1Score, p2Score)) {
                return translator.translate(p1Score, p2Score);
            }
        }

        return p1Score + "-" + p2Score;
    }
}