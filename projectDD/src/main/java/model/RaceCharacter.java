package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class RaceCharacter {

    @Setter
    private String nameRace;

    @Setter
    private String nameSubRace;

    private final Map<AbilitiesModifierEnum, Integer> abilitiesAndBonus;

    public RaceCharacter() {
        this.abilitiesAndBonus = new HashMap<>();
        this.nameRace = "";
        this.nameSubRace = "";
    }

    @Override
    public String toString() {
        return "RaceCharacter{" +
                "nameRace='" + nameRace + '\'' +
                ", nameSubRace='" + nameSubRace + '\'' +
                ", abilitiesAndBonus=" + abilitiesAndBonus +
                '}';
    }
}
