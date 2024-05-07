package model;

import lombok.ToString;

@ToString
public class Intelligence extends AbilitiesModifier {

    public Intelligence() {
        setScore(0);
        setModifier(0);
    }

    public Intelligence(int score){
        setScore(score);
    }
}
