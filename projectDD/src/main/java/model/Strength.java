package model;

import lombok.ToString;

@ToString
public class Strength extends AbilitiesModifier {

    public Strength() {
        setAttribute(0);
        setModifier(0);
    }

    public Strength(int score){
        setAttribute(score);
    }
}
