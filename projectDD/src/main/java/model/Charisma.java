package model;

import lombok.ToString;

@ToString
public class Charisma extends ModifyingSkills {

    public Charisma() {
        setScore(0);
        setModifier(0);
    }

    public Charisma(int score){
        setScore(score);
        calculateModifier();
    }
}
