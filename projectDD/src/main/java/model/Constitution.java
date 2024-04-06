package model;

import lombok.ToString;

@ToString
public class Constitution extends ModifyingSkills {

    public Constitution() {
        setScore(0);
        setModifier(0);
    }

    public Constitution(int score){
        setScore(score);
        calculateModifier();
    }
}
