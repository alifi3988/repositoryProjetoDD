package model;

import lombok.ToString;

@ToString
public class Intelligence extends ModifyingSkills {

    public Intelligence() {
        setScore(0);
        setModifier(0);
    }

    public Intelligence(int score){
        setScore(score);
        calculateModifier();
    }
}
