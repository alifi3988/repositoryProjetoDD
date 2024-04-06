package model;

import lombok.ToString;

@ToString
public class Strength extends ModifyingSkills {

    public Strength() {
        setScore(0);
        setModifier(0);
    }

    public Strength(int score){
        setScore(score);
        calculateModifier();
    }
}
