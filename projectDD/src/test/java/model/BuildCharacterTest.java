package model;

import jakarta.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
                7,
                3
        );
    }

    @Test
    public void should_validate_level_and_proficiency_bonus_true() {
        Assert.assertEquals(true, buildCharacter.validateLevelAndProficiencyBonus(7, 3));
    }

    @Test
    public void should_validate_level_and_proficiency_bonus_false() {
        Assert.assertEquals(false, buildCharacter.validateLevelAndProficiencyBonus(8, 2));
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
    public void should_perform_the_saving_throw_as_modify_skills_enums_is_all_skill(){
        Assert.assertTrue(buildCharacter.generateEnduranceTest(
                7,
                AbilitiesModifierEnum.ALL_ABILITIES));
    }
}
