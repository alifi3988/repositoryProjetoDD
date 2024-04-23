package model;

import lombok.ToString;

@ToString
public class Wisdom extends ModifySkills {

    public Wisdom() {
        setScore(0);
        setModifier(0);
    }

    public Wisdom(int score){
        setScore(score);
    }
}
