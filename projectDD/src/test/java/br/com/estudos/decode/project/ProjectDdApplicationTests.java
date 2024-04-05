package br.com.estudos.decode.project;

import model.Character;
import model.Charisma;
import model.Constitution;
import model.Dexterity;
import model.Intelligence;
import model.Strength;
import model.Wisdom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectDdApplicationTests {

	@Test
    public void shouldShowTheSkills () {
		Character character = new Character();
		System.out.println(character.getSkils());
	}

	@Test
	public void shouldCalculateTheValueOfTheModifier (){

		Character character = new Character(
                new Strength(),
                new Dexterity(),
                new Constitution(),
                new Intelligence(),
                new Wisdom(),
                new Charisma(),
				0
        );

		character.getStrength().setScore(15);
		character.getStrength().calculateModifier();

		character.getDexterity().setScore(1);
		character.getDexterity().calculateModifier();

		character.getConstitution().setScore(8);
		character.getConstitution().calculateModifier();

		character.getIntelligence().setScore(22);
		character.getIntelligence().calculateModifier();

		character.getWisdom().setScore(19);
		character.getWisdom().calculateModifier();

		character.getCharisma().setScore(29);
		character.getCharisma().calculateModifier();

		assertEquals(2, character.getStrength().getModifier());
		assertEquals(-5, character.getDexterity().getModifier());
		assertEquals(-1, character.getConstitution().getModifier());
		assertEquals(6, character.getIntelligence().getModifier());
		assertEquals(4, character.getWisdom().getModifier());
		assertEquals(9, character.getCharisma().getModifier());
	}

	@Test
	public void shouldCalculateProficiencyAndLevelBonusesByExperiencePointsInEveryInstance (){

		Character characterPrimeiro = new Character(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				381
		);
		assertEquals("Validação do nível: ", 2, characterPrimeiro.getLevel());
		assertEquals("Validação do bonus de proficiência: ", 2, characterPrimeiro.getProficiencyBonus());

		Character characterSegundo = new Character(
				new Strength(),
				new Dexterity(),
				new Constitution(),
				new Intelligence(),
				new Wisdom(),
				new Charisma(),
				85039
		);
		assertEquals("Validação do nível: ", 11, characterSegundo.getLevel());
		assertEquals("Validação do bonus de proficiência: ", 4, characterSegundo.getProficiencyBonus());
	}

}


