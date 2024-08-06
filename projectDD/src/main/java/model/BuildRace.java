package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BuildRace {
    private String name;
    private HashMap<String, String> additional_data; //será inserido nesse campo, as informações da RACA
    private HashMap<AbilitiesModifierEnum, Integer> abilitiesAndBonus;
}
