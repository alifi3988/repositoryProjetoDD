package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private Strength strength;
    private Dexterity dexterity;
    private Constitution constitution;
    private Intelligence intelligence;
    private Wisdom wisdom;
    private Charisma charisma;
    private int proficiencyBonus;
    private int experiencePoints;
    private int level;

    public Character(Strength strength, Dexterity dexterity, Constitution constitution, Intelligence intelligence, Wisdom wisdom, Charisma charisma, int experiencePoints) {
        setStrength(strength);
        setDexterity(dexterity);
        setConstitution(constitution);
        setIntelligence(intelligence);
        setWisdom(wisdom);
        setCharisma(charisma);
        setExperiencePoints(experiencePoints);
        setProficiencyBonusAndLevel(experiencePoints);
    }

    public Character getSkils() {
        return this;
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
}
