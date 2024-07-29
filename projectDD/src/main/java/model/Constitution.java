package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Constitution extends AbilitiesScoreAndModifier {

    public Constitution() {
        setScore(0);
        setModifier(0);
    }

    public Constitution(int score){
        setScore(score);
    }
}
