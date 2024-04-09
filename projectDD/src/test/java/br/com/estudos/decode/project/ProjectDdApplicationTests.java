package br.com.estudos.decode.project;

import br.com.estudos.decode.project.exception.ExceptionMensagen;
import model.BuildCharacter;
import model.Charisma;
import model.Constitution;
import model.Dexterity;
import model.Intelligence;
import model.ModifyingSkillsEnum;
import model.Strength;
import model.Wisdom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProjectDdApplicationTests {

	@Test
    public void shouldShowTheSkills () throws ExceptionMensagen {
		BuildCharacter buildCharacter = new BuildCharacter(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				13,
				6
		);

	}

	@Test
	public void shouldShowTheSkillsAndAttribute () {

		BuildCharacter buildCharacter = new BuildCharacter(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				0
		);

		System.out.println(buildCharacter);
	}

	@Test
	public void shouldCalculateTheValueOfTheModifier (){

		BuildCharacter buildCharacter = new BuildCharacter(
                new Strength(),
                new Dexterity(),
                new Constitution(),
                new Intelligence(),
                new Wisdom(),
                new Charisma(),
				0
        );

		buildCharacter.getStrength().setScore(15);
		buildCharacter.getStrength().calculateModifier();

		buildCharacter.getDexterity().setScore(1);
		buildCharacter.getDexterity().calculateModifier();

		buildCharacter.getConstitution().setScore(8);
		buildCharacter.getConstitution().calculateModifier();

		buildCharacter.getIntelligence().setScore(22);
		buildCharacter.getIntelligence().calculateModifier();

		buildCharacter.getWisdom().setScore(19);
		buildCharacter.getWisdom().calculateModifier();

		buildCharacter.getCharisma().setScore(29);
		buildCharacter.getCharisma().calculateModifier();

		assertEquals(2, buildCharacter.getStrength().getModifier());
		assertEquals(-5, buildCharacter.getDexterity().getModifier());
		assertEquals(-1, buildCharacter.getConstitution().getModifier());
		assertEquals(6, buildCharacter.getIntelligence().getModifier());
		assertEquals(4, buildCharacter.getWisdom().getModifier());
		assertEquals(9, buildCharacter.getCharisma().getModifier());
	}

	@Test
	public void shouldCalculateProficiencyAndLevelBonusesByExperiencePointsInEveryInstance (){

		BuildCharacter buildCharacterPrimeiro = new BuildCharacter(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				381
		);
		assertEquals("Validação do nível: ", 2, buildCharacterPrimeiro.getLevel());
		assertEquals("Validação do bonus de proficiência: ", 2, buildCharacterPrimeiro.getProficiencyBonus());

		BuildCharacter buildCharacterSegundo = new BuildCharacter(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				85039
		);
		assertEquals("Validação do nível: ", 11, buildCharacterSegundo.getLevel());
		assertEquals("Validação do bonus de proficiência: ", 4, buildCharacterSegundo.getProficiencyBonus());
	}

	@Test
	public void shouldPerformTheSavingThrowAsTrue () {

		BuildCharacter buildCharacter = new BuildCharacter(
				new Strength(10),
				new Dexterity(15),
				new Constitution(26),
				new Intelligence(6),
				new Wisdom(9),
				new Charisma(10),
				5601
		);

		boolean testResult = buildCharacter.generateEnduranceTest(
				10,
				ModifyingSkillsEnum.STRENGTH,
				ModifyingSkillsEnum.CONSTITUTION,
				ModifyingSkillsEnum.WISDOM);

		assertTrue(testResult);
	}

	@Test
	public void shouldPerformTheSavingThrowAsFalse () {

		BuildCharacter buildCharacter = new BuildCharacter(
				new Strength(10),
				new Dexterity(15),
				new Constitution(26),
				new Intelligence(6),
				new Wisdom(9),
				new Charisma(10),
				5601
		);

		boolean testResult = buildCharacter.generateEnduranceTest(
				30,
				ModifyingSkillsEnum.STRENGTH,
				ModifyingSkillsEnum.CONSTITUTION,
				ModifyingSkillsEnum.WISDOM);

		assertFalse(testResult);
	}

}


