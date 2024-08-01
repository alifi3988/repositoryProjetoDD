package model;

import base.BuildCharacter;
import jakarta.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BuildCharacterTest {

    @Inject
    BuildCharacter buildCharacter;

    @Before
    public void before() throws Exception {

        this.buildCharacter = new BuildCharacter(
                new Strength(10),
                new Dexterity(15),
                new Constitution(3),
                new Intelligence(9),
                new Wisdom(7),
                new Charisma(1),
                7, new RaceCharacter()
        );
    }

    @Test
    public void should_validate_level_and_proficiency_bonus() {
        buildCharacter.updateProficiencyBonusByLevel(7);
        Assert.assertEquals(buildCharacter.getProficiencyBonus(), 3);

        buildCharacter.updateProficiencyBonusByLevel(5);
        Assert.assertEquals(buildCharacter.getProficiencyBonus(), 3);

        buildCharacter.updateProficiencyBonusByLevel(14);
        Assert.assertEquals(buildCharacter.getProficiencyBonus(), 5);
    }

    @Test
    public void should_test_update_proficiency_bonus_by_level_invalid_level() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            buildCharacter.updateProficiencyBonusByLevel(21);
        });
    }

    @Test
    public void should_perform_the_saving_throw_as_true() {
        Assert.assertTrue(buildCharacter.generateEnduranceTest(
                3,
                AbilitiesModifierEnum.STRENGTH,
                AbilitiesModifierEnum.CONSTITUTION,
                AbilitiesModifierEnum.WISDOM));
    }

    @Test
    public void should_perform_the_saving_throw_as_false() {
        Assert.assertFalse(buildCharacter.generateEnduranceTest(
                10,
                AbilitiesModifierEnum.STRENGTH,
                AbilitiesModifierEnum.CONSTITUTION,
                AbilitiesModifierEnum.WISDOM));
    }

    @Test
    public void should_perform_the_saving_throw_as_modify_skills_enums_is_none_skill() {
        Assert.assertFalse(buildCharacter.generateEnduranceTest(
                10,
                AbilitiesModifierEnum.NONE_ABILITIES));
    }

    @Test
    public void should_perform_the_saving_throw_as_modify_skills_enums_is_all_skill() {
        Assert.assertTrue(buildCharacter.generateEnduranceTest(
                7,
                AbilitiesModifierEnum.ALL_ABILITIES));
    }

//    @Test
//    public void should_validate_the_correct_abilities_from_meted_race(){
//
//        int beforeAtribute = buildCharacter.getConstitution().getScore();
//
//        Map<AbilitiesModifierEnum, Integer> race = new HashMap<>();
//        race.put(AbilitiesModifierEnum.CONSTITUTION, 2);
//
//        buildCharacter.setRace("HUMANO", race);
//
//        int atributeAfter = buildCharacter.getConstitution().getScore();
//
//        Assert.assertEquals(beforeAtribute + 2, atributeAfter);
//    }

}
