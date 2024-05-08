package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuildCharacter {

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
        if(level >= 1 && level <= 4 && proficiencyBonus == 2) return true;
        else if (level >= 5 && level <= 8 && proficiencyBonus == 3) return true;
        else if (level >= 9 && level <= 12 && proficiencyBonus == 4) return true;
        else if (level >= 13 && level <= 16 && proficiencyBonus == 5) return true;
        else if (level >= 17 && level <= 20 && proficiencyBonus == 6) return true;
        return false;
    }

    public boolean generateEnduranceTest(int difficultyValue, AbilitiesModifierEnum... abilitiesModifierEnums) {
        int proficiencyBonusAssistant = 0;
        if((abilitiesModifierEnums.length >= 1) && (!abilitiesModifierEnums[0].equals(AbilitiesModifierEnum.NONE_ABILITIES))) {
            proficiencyBonusAssistant = getProficiencyBonus();
        }
        return calculateValueEndurance(proficiencyBonusAssistant, abilitiesModifierEnums) >= difficultyValue;
    }

    private Integer calculateValueEndurance(int proficiencyBonusAssistant, AbilitiesModifierEnum... abilitiesModifierEnums) {

        int valueEndurance = 0;
        for (AbilitiesModifierEnum skill: abilitiesModifierEnums) {
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

//    private void setProficiencyBonusAndLevel(int experience) throws ExceptionMensagen {
//
//        int valorLevel = 0;
//        int valorProficiencyBonus = 0;
//
//
//        if (experience < 300){
//            valorLevel = 1;
//            valorProficiencyBonus = 2;
//        }
//
//        if (experience >= 300 && experience < 900){
//            valorLevel = 2;
//            valorProficiencyBonus = 2;
//        }
//
//        if (experience >= 900 && experience < 2700){
//            valorLevel = 3;
//            valorProficiencyBonus = 2;
//        }
//
//        if (experience >= 2700 && experience < 6500){
//            valorLevel = 4;
//            valorProficiencyBonus = 2;
//        }
//
//        if (experience >= 6500 && experience < 14000){
//            valorLevel = 5;
//            valorProficiencyBonus = 3;
//        }
//
//        if (experience >= 14000 && experience < 23000){
//            valorLevel = 6;
//            valorProficiencyBonus = 3;
//        }
//
//        if (experience >= 23000 && experience < 34000){
//            valorLevel = 7;
//            valorProficiencyBonus = 3;
//        }
//
//        if (experience >= 34000 && experience < 48000){
//            valorLevel = 8;
//            valorProficiencyBonus = 3;
//        }
//
//        if (experience >= 48000 && experience < 64000){
//            valorLevel = 9;
//            valorProficiencyBonus = 4;
//        }
//
//        if (experience >= 64000 && experience < 85000){
//            valorLevel = 10;
//            valorProficiencyBonus = 4;
//        }
//
//        if (experience >= 85000 && experience < 100000){
//            valorLevel = 11;
//            valorProficiencyBonus = 4;
//        }
//
//        if (experience >= 100000 && experience < 120000){
//            valorLevel = 12;
//            valorProficiencyBonus = 4;
//        }
//
//        if (experience >= 120000 && experience < 140000){
//            valorLevel = 13;
//            valorProficiencyBonus = 5;
//        }
//
//        if (experience >= 140000 && experience < 165000){
//            valorLevel = 14;
//            valorProficiencyBonus = 5;
//        }
//
//        if (experience >= 165000 && experience < 195000){
//            valorLevel = 15;
//            valorProficiencyBonus = 5;
//        }
//
//        if (experience >= 195000 && experience < 225000){
//            valorLevel = 16;
//            valorProficiencyBonus = 5;
//        }
//
//        if (experience >= 225000 && experience < 265000){
//            valorLevel = 17;
//            valorProficiencyBonus = 6;
//        }
//
//        if (experience >= 265000 && experience < 305000){
//            valorLevel = 18;
//            valorProficiencyBonus = 6;
//        }
//
//        if (experience >= 305000 && experience < 355000){
//            valorLevel = 19;
//            valorProficiencyBonus = 6;
//        }
//
//        if (experience >= 355000){
//            valorLevel = 20;
//            valorProficiencyBonus = 6;
//        }
//
//        setLevel(valorLevel);
//        setProficiencyBonus(valorProficiencyBonus);
//    }

}
