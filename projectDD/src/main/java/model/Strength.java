package model;

import base.AbilitiesScoreAndModifier;
import lombok.ToString;

@ToString
public class Strength extends AbilitiesScoreAndModifier {

    public Strength() {
        setScore(0);
        setModifier(0);
    }

    //quando setar o valor do score (habilidade), já será determinado o valor do modificador automaticamente
    public Strength(int score){
        setScore(score);
    }
}
