package model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public abstract class ModifySkills {

    private int score;
    private int modifier;

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        calculateModifier(score);
    }

    private void calculateModifier(int score) {

        double calculationBaseModifier = (double) (score - 10) / 2;

        if (score % 2 != 0 && calculationBaseModifier < 0) {
            int calculation = (int) Math.ceil(((calculationBaseModifier) * -1));
            setModifier(-1 * calculation);
        } else if (score % 2 != 0 && calculationBaseModifier >= 0) {
            setModifier((int) Math.floor(calculationBaseModifier));
        } else {
            setModifier((int) calculationBaseModifier);
        }
    }

}
