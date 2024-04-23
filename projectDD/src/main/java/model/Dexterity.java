package model;

import lombok.ToString;

@ToString
public class Dexterity extends ModifySkills {

    public Dexterity() {
        setScore(0);
        setModifier(0);
    }

    public Dexterity(int score){
        setScore(score);
    }
}
