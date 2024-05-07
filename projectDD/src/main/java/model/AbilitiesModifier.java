package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//https://online.visual-paradigm.com/w/wlraitjj/diagrams/#diagram:proj=0&import=draw.io&type=BlockDiagram
@ToString
@Getter
@NoArgsConstructor
public abstract class AbilitiesModifier {

    private int score;
    @Setter
    private int modifier;

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
