package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Intelligence extends AbilitiesScoreAndModifier {

    public Intelligence() {
        setScore(0);
        setModifier(0);
    }

    public Intelligence(int score){
        setScore(score);
    }
}
