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

    public ModifyingSkills() {
        this.score = 0;
        this.modifier = 0;
    }

    public void calculateModifier(){

        double calculationBaseModifier = (double) (this.score - 10) /2;

        if (this.score % 2 != 0 && calculationBaseModifier < 0) {
            int calculo = (int) Math.ceil(((calculationBaseModifier) * -1));
            this.modifier = (-1 * calculo);
        } else if (this.score % 2 != 0 && calculationBaseModifier >= 0) {
            this.modifier = (int) Math.floor(calculationBaseModifier);
        }else{
            this.modifier = (int) calculationBaseModifier;
        }
    }

}
