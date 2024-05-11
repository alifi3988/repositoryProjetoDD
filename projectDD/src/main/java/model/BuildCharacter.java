package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuildCharacter extends RaceCharacter {

    private boolean inspiration;
    private final Strength strength;
    private final Dexterity dexterity;
    private final Constitution constitution;
    private final Intelligence intelligence;
    private final Wisdom wisdom;
    private final Charisma charisma;
    private int proficiencyBonus;
    private int level;

    public BuildCharacter(Strength strength, Dexterity dexterity, Constitution constitution,
                          Intelligence intelligence, Wisdom wisdom, Charisma charisma,
                          int level, int proficiencyBonus) throws Exception {
        if (validateLevelAndProficiencyBonus(level, proficiencyBonus)) {
            this.inspiration = false;
            this.strength = strength;
            this.dexterity = dexterity;
            this.constitution = constitution;
            this.intelligence = intelligence;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.level = level;
            this.proficiencyBonus = proficiencyBonus;
        } else {
            throw new
                    Exception("Erro! Valores de Nível e Bonus de Proficiência não estão corretos, de acordo com a tabela do Jogador. " +
                    "\nVerificar Livro do Jogador - pag 15. ");
        }
    }

    public void setLevel(int level) throws Exception {
        if (validateLevelAndProficiencyBonus(level, getProficiencyBonus())) {
            this.level = level;
        } else {
            throw new
                    Exception("Erro! Valores de Nível e Bonus de Proficiência não estão corretos, de acordo com a tabela do Jogador. " +
                    "\nVerificar Livro do Jogador - pag 15. ");
        }
    }

    public void setProficiencyBonus(int proficiencyBonus) throws Exception {
        if (validateLevelAndProficiencyBonus(getLevel(), proficiencyBonus)) {
            this.proficiencyBonus = proficiencyBonus;
        } else {
            throw new Exception("Erro! Valores de Nível e Bonus de Proficiência não estão corretos, de acordo com a tabela do Jogador. " +
                    "\nVerificar Livro do Jogador - pag 15. ");
        }
    }

    public boolean validateLevelAndProficiencyBonus(int level, int proficiencyBonus) {
        if (level >= 1 && level <= 4 && proficiencyBonus == 2) return true;
        else if (level >= 5 && level <= 8 && proficiencyBonus == 3) return true;
        else if (level >= 9 && level <= 12 && proficiencyBonus == 4) return true;
        else if (level >= 13 && level <= 16 && proficiencyBonus == 5) return true;
        else if (level >= 17 && level <= 20 && proficiencyBonus == 6) return true;
        return false;
    }

    public boolean generateEnduranceTest(int difficultyValue, AbilitiesModifierEnum... abilitiesModifierEnums) {
        int proficiencyBonusAssistant = 0;
        if ((abilitiesModifierEnums.length >= 1) && (!abilitiesModifierEnums[0].equals(AbilitiesModifierEnum.NONE_ABILITIES))) {
            proficiencyBonusAssistant = getProficiencyBonus();
        }
        return calculateValueEndurance(proficiencyBonusAssistant, abilitiesModifierEnums) >= difficultyValue;
    }

    //TODO: preciso termianr isso
    public void toAddRace(AbilitiesModifierEnum abilitiesModifierEnum, int bonus) {
        if (!getAbilitiesAndBonus().containsKey(abilitiesModifierEnum)) {
            getAbilitiesAndBonus().put(abilitiesModifierEnum, bonus);
            AbilitiesModifier ability = abilitiesModifierEnum.createAbilityInstance();
            ability.setAttribute(10); // não é assim
        }
    }

    public void toAddSubRace(AbilitiesModifierEnum abilitiesModifierEnum, int bonus) {
        getAbilitiesAndBonus().put(abilitiesModifierEnum, bonus);
    }

    private void calculationBonus() {

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
