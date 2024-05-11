package model;

import lombok.ToString;

@ToString
public class Dexterity extends AbilitiesModifier {

    public Dexterity() {
        setAttribute(0);
        setModifier(0);
    }

    public Dexterity(int score){
        setAttribute(score);
    }
}
