package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class ModifyingSkills {

    private int score;
    private int modifier;

    public ModifyingSkills(){}

    public void calculateModifier(){

        int scoreAssistant = getScore();

        double calculationBaseModifier = (double) (scoreAssistant - 10) /2;

        if (scoreAssistant % 2 != 0 && calculationBaseModifier < 0) {
            int calculo = (int) Math.ceil(((calculationBaseModifier) * -1));
            setModifier(-1 * calculo);
        } else if (scoreAssistant % 2 != 0 && calculationBaseModifier >= 0) {
            setModifier((int) Math.floor(calculationBaseModifier));
        }else{
            setModifier((int) calculationBaseModifier);
        }
    }

}
