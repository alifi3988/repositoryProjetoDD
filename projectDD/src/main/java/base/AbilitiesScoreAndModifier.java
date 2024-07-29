package base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public abstract class AbilitiesScoreAndModifier {

    private int score;
    private int modifier;

    //Setando o valor do score e depois realizando calculo do modificador da habilidade
    public void setScore(int score) {
        this.score = score;
        calculateModifier(score);
    }

    //método para realizar o calculo do modificador da habilidade
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
