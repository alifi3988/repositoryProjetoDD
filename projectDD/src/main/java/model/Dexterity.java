package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Dexterity extends AbilitiesScoreAndModifier {

    public Dexterity() {
        setScore(0);
        setModifier(0);
    }

    public Dexterity(int score){
        setScore(score);
    }
}
