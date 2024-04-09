package model;

import br.com.estudos.decode.project.exception.ExceptionMensagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuildCharacter {

    private Strength strength;
    private Dexterity dexterity;
    private Constitution constitution;
    private Intelligence intelligence;
    private Wisdom wisdom;
    private Charisma charisma;
    private int proficiencyBonus;
    private int experiencePoints;
    private int level;

    public BuildCharacter(Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence, Wisdom wisdom, Charisma charisma, int experiencePoints) {
        setStrength(strength);
        setDexterity(dexterity);
        setConstitution(constitution);
        setIntelligence(intelligence);
        setWisdom(wisdom);
        setCharisma(charisma);
        setExperiencePoints(experiencePoints);
        setProficiencyBonusAndLevel(experiencePoints);
    }

    public BuildCharacter(Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence, Wisdom wisdom, Charisma charisma, int level, int proficiencyBonus) throws ExceptionMensagen {

        if(validateLevelAndProficiencyBonus(level, proficiencyBonus)) {
            setStrength(strength);
            setDexterity(dexterity);
            setConstitution(constitution);
            setIntelligence(intelligence);
            setWisdom(wisdom);
            setCharisma(charisma);
            setExperiencePoints(0);
            setLevel(level);
            setProficiencyBonus(proficiencyBonus);
        }else{
             throw new ExceptionMensagen("Erro! Valores de Nível e Bonus de Proficiência não estão corretos, de acordo com a tabela do Jogador. \n Verificar Livro do Jogador - pag 15. ");
        }

    }

    public BuildCharacter getSkils() {
        return this;
    }

    public boolean validateLevelAndProficiencyBonus(int level, int proficiencyBonus){
        if(level >= 1 && level <= 4 && proficiencyBonus == 2) return true;
        else if (level >= 5 && level <= 8 && proficiencyBonus == 3) return true;
        else if (level >= 9 && level <= 12 && proficiencyBonus == 4) return true;
        else if (level >= 13 && level <= 16 && proficiencyBonus == 5) return true;
        else if (level >= 17 && level <= 20 && proficiencyBonus == 6) return true;
        return false;
    }

    public void setProficiencyBonusAndLevel(int experience){
        System.out.println("[BEGIN] - setProficiencyBonusAndLevel()");

        if (experience < 300){
            setLevel(1);
            setProficiencyBonus(2);
        }

        if (experience >= 300 && experience < 900){
            setLevel(2);
            setProficiencyBonus(2);
        }

        if (experience >= 900 && experience < 2700){
            setLevel(3);
            setProficiencyBonus(2);
        }

        if (experience >= 2700 && experience < 6500){
            setLevel(4);
            setProficiencyBonus(2);
        }


        if (experience >= 6500 && experience < 14000){
            setLevel(5);
            setProficiencyBonus(3);
        }

        if (experience >= 14000 && experience < 23000){
            setLevel(6);
            setProficiencyBonus(3);
        }

        if (experience >= 23000 && experience < 34000){
            setLevel(7);
            setProficiencyBonus(2);
        }

        if (experience >= 34000 && experience < 48000){
            setLevel(8);
            setProficiencyBonus(2);
        }

        if (experience >= 48000 && experience < 64000){
            setLevel(9);
            setProficiencyBonus(4);
        }

        if (experience >= 64000 && experience < 85000){
            setLevel(10);
            setProficiencyBonus(4);
        }

        if (experience >= 85000 && experience < 100000){
            setLevel(11);
            setProficiencyBonus(4);
        }

        if (experience >= 100000 && experience < 120000){
            setLevel(12);
            setProficiencyBonus(4);
        }

        if (experience >= 120000 && experience < 140000){
            setLevel(13);
            setProficiencyBonus(5);
        }

        if (experience >= 140000 && experience < 165000){
            setLevel(14);
            setProficiencyBonus(5);
        }

        if (experience >= 165000 && experience < 195000){
            setLevel(15);
            setProficiencyBonus(5);
        }

        if (experience >= 195000 && experience < 225000){
            setLevel(16);
            setProficiencyBonus(5);
        }

        if (experience >= 225000 && experience < 265000){
            setLevel(17);
            setProficiencyBonus(6);
        }

        if (experience >= 265000 && experience < 305000){
            setLevel(18);
            setProficiencyBonus(6);
        }

        if (experience >= 305000 && experience < 355000){
            setLevel(19);
            setProficiencyBonus(6);
        }

        if (experience >= 355000){
            setLevel(20);
            setProficiencyBonus(6);
        }
        System.out.println("[END] - setProficiencyBonusAndLevel()");
    }

    public boolean generateEnduranceTest(int difficultyValue, ModifyingSkillsEnum... modifyingSkillsEnums){

        int proficiencyBonusAssistant = 0;

        if((modifyingSkillsEnums.length == 1) &&
                (modifyingSkillsEnums[0] == ModifyingSkillsEnum.NONE_SKILL)) {
        }else{
            proficiencyBonusAssistant = getProficiencyBonus();
        }

        return calculateValueEndurance(proficiencyBonusAssistant, modifyingSkillsEnums) >= difficultyValue;
    }

    public Integer calculateValueEndurance(int proficiencyBonusAssistant, ModifyingSkillsEnum... modifyingSkillsEnums){

        int valueEndurance = 0;

        for (ModifyingSkillsEnum skills: modifyingSkillsEnums) {
            switch (skills) {
                case ModifyingSkillsEnum.STRENGTH:
                    valueEndurance = valueEndurance + getStrength().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.DEXTERITY:
                    valueEndurance = valueEndurance + getDexterity().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.CONSTITUTION:
                    valueEndurance = valueEndurance + getConstitution().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.INTELLIGENCE:
                    valueEndurance = valueEndurance + getIntelligence().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.WISDOM:
                    valueEndurance = valueEndurance + getWisdom().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.CHARISMA:
                    valueEndurance = valueEndurance + getCharisma().getModifier() + proficiencyBonusAssistant;
                    break;
                case ModifyingSkillsEnum.ALL_SKILLS:
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
