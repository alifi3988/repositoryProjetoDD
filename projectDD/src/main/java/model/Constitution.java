package model;

import lombok.ToString;

@ToString
public class Constitution extends AbilitiesModifier {

    public Constitution() {
        setAttribute(0);
        setModifier(0);
    }

    public Constitution(int score){
        setAttribute(score);
    }
}
