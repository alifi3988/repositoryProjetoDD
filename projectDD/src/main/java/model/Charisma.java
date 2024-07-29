package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Charisma extends AbilitiesScoreAndModifier {

    public Charisma() {
        setScore(0);
        setModifier(0);
    }

    public Charisma(int score){ setScore(score); }
}
