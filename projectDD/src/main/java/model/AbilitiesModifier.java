package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public abstract class AbilitiesModifier {

    private int attribute;
    private int modifier;

    public void setAttribute(int attribute) {
        this.attribute = attribute;
        calculateModifier(attribute);
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
