package base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.AbilitiesModifierEnum;
import model.Charisma;
import model.Constitution;
import model.Dexterity;
import model.Intelligence;
import model.RaceCharacter;
import model.Strength;
import model.Wisdom;

import java.util.Map;

@Getter
@Setter
@ToString
public class BuildCharacter {

    private boolean inspiration;
    private Charisma charisma;
    private Constitution constitution;
    private Dexterity dexterity;
    private Intelligence intelligence;
    private Strength strength;
    private Wisdom wisdom;
    private int proficiencyBonus;
    private int level;
    private RaceCharacter race;

    public BuildCharacter(Strength strength, Dexterity dexterity, Constitution constitution,
                          Intelligence intelligence, Wisdom wisdom, Charisma charisma,
                          int level, RaceCharacter race) throws Exception {
        this.inspiration = false;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.level = level;
        updateProficiencyBonusByLevel(level);
        this.race = race;

        validateRaceAndSubRace();

    }

    public void updateProficiencyBonusByLevel(int level) throws IllegalArgumentException {
        if (level < 1 || level > 20) {
            throw new IllegalArgumentException("Level must be between 1 and 20");
        }
        if (level <= 4) setProficiencyBonus(2);
        else if (level <= 8) setProficiencyBonus(3);
        else if (level <= 12) setProficiencyBonus(4);
        else if (level <= 16) setProficiencyBonus(5);
        else setProficiencyBonus(6);
    }

    public boolean generateEnduranceTest(int difficultyValue, AbilitiesModifierEnum... abilitiesModifierEnums) {
        int proficiencyBonusAssistant = 0;
        if ((abilitiesModifierEnums.length >= 1) && (!abilitiesModifierEnums[0].equals(AbilitiesModifierEnum.NONE_ABILITIES))) {
            proficiencyBonusAssistant = getProficiencyBonus();
        }
        return calculateValueEndurance(proficiencyBonusAssistant, abilitiesModifierEnums) >= difficultyValue;
    }

    private void validateRaceAndSubRace(){
        RaceCharacter raceAuxiliar = getRace();

        updateValorModifier(raceAuxiliar.getAbilitiesAndBonus());

        if (!raceAuxiliar.getSubRace().getName().isEmpty()) {
            updateValorModifier(raceAuxiliar.getSubRace().getAbilitiesAndBonus());
        }
    }

    //TODO: realizar a validação do valor não pode passar de 20
    private void updateValorModifier(Map<AbilitiesModifierEnum, Integer> abilitiesAndValue) {

        abilitiesAndValue.forEach((key, value) -> {

            var abilitiesModifierAux = key.createAbilityInstance();

            if (abilitiesModifierAux instanceof Charisma) {
                getCharisma().updateScore(value);
            }
            if (abilitiesModifierAux instanceof Constitution) {
                getConstitution().updateScore(value);
            }
            if (abilitiesModifierAux instanceof Dexterity) {
                getDexterity().updateScore(value);
            }
            if (abilitiesModifierAux instanceof Intelligence) {
                getIntelligence().updateScore(value);
            }
            if (abilitiesModifierAux instanceof Strength) {
                getStrength().updateScore(value);
            }
            if (abilitiesModifierAux instanceof Wisdom) {
                getWisdom().updateScore(value);
            }
        });
    }

    private Integer calculateValueEndurance(int proficiencyBonusAssistant, AbilitiesModifierEnum... abilitiesModifierEnums) {

        int valueEndurance = 0;
        for (AbilitiesModifierEnum skill : abilitiesModifierEnums) {
            switch (skill) {
                case AbilitiesModifierEnum.STRENGTH:
                    valueEndurance = valueEndurance + getStrength().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.DEXTERITY:
                    valueEndurance = valueEndurance + getDexterity().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.CONSTITUTION:
                    valueEndurance = valueEndurance + getConstitution().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.INTELLIGENCE:
                    valueEndurance = valueEndurance + getIntelligence().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.WISDOM:
                    valueEndurance = valueEndurance + getWisdom().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.CHARISMA:
                    valueEndurance = valueEndurance + getCharisma().getModifier() + proficiencyBonusAssistant;
                    break;
                case AbilitiesModifierEnum.ALL_ABILITIES:
                    valueEndurance = valueEndurance +
                            getStrength().getModifier() + proficiencyBonusAssistant +
                            getDexterity().getModifier() + proficiencyBonusAssistant +
                            getConstitution().getModifier() + proficiencyBonusAssistant +
                            getIntelligence().getModifier() + proficiencyBonusAssistant +
                            getWisdom().getModifier() + proficiencyBonusAssistant +
                            getCharisma().getModifier() + proficiencyBonusAssistant;
                    break;
            }
        }
        return valueEndurance;
    }
}
