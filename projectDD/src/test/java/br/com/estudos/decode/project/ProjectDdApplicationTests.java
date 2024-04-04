package br.com.estudos.decode.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectDdApplicationTests {

	@ToString
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Character {

		private Strength strength;
		private Dexterity dexterity;
		private Constitution constitution;
		private Intelligence intelligence;
		private Wisdom wisdom;
		private Charisma charisma;

		public Character getSkils() {
			return this;
		}
	}

	@ToString
	public static class Strength extends ModifyingSkills {

	}

	@ToString
	public static class Dexterity extends ModifyingSkills {

	}

	@ToString
	public static class Constitution extends ModifyingSkills {

	}

	@ToString
	public static class Intelligence extends ModifyingSkills {

	}

	@ToString
	public static class Wisdom extends ModifyingSkills {

	}

	@ToString
	public static class Charisma extends ModifyingSkills {

	}

	@ToString
	@Getter
	@Setter
	public static class ModifyingSkills {

		private int score;
		private int modifier;

		public ModifyingSkills() {
			this.score = 0;
			this.modifier = 0;
		}

		public void calculateModifier(){

			double calculationBaseModifier = (double) (score - 10) /2;

			if (this.score % 2 != 0 && this.score < 0){
				this.modifier = (int) Math.round(calculationBaseModifier);
			}else if (this.score % 2 != 0 && this.score >= 0){
				this.modifier = (int) Math.floor(calculationBaseModifier);
			}
		}

	}

	@Test
    public void shouldShowTheSkills() {
		Character character = new Character();
		System.out.println(character.getSkils());
	}

	@Test
	public void shouldCalculateTheValueOfTheModifier(){

		Character character = new Character(
                new Strength(),
                new Dexterity(),
                new Constitution(),
                new Intelligence(),
                new Wisdom(),
                new Charisma()
        );

		character.getStrength().setScore(15);
		character.getStrength().calculateModifier();

		assertEquals(2, character.getStrength().getModifier());

	}

}


