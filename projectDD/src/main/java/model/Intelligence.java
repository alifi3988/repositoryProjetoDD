package model;

import lombok.ToString;

@ToString
public class Intelligence extends AbilitiesModifier {

    public Intelligence() {
        setAttribute(0);
        setModifier(0);
    }

    public Intelligence(int score){
        setAttribute(score);
    }
}
