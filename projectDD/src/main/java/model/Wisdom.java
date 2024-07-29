package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Wisdom extends AbilitiesScoreAndModifier {

    public Wisdom() {
        setScore(0);
        setModifier(0);
    }

    public Wisdom(int score){
        setScore(score);
    }
}
