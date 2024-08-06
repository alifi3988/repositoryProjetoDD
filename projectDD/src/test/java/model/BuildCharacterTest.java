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
                7, fillInRaceAndSubRace()
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

    @Test
    public void should_validate_exception_when_trying_to_override_race_with_information() {

        IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () -> buildCharacter.setRaceAndSubRace(fillInRaceAndSubRace()));

        Assert.assertEquals("Erro! Impossível sobrepor informações de raca dessa forma!", exception.getMessage());
    }

    @Test
    public void should_validate_at_information_about_race_and_sub_race() {

        RaceCharacter raceAux = buildCharacter.getRace();

        Assert.assertEquals("AASIMAR", raceAux.getName());
        Assert.assertEquals("Flagelo", raceAux.getSubRace().getName());
    }

    private RaceCharacter fillInRaceAndSubRace() {

        RaceCharacter raceCharacter = new RaceCharacter();
        raceCharacter.setName("AASIMAR");
        HashMap<AbilitiesModifierEnum, Integer> bonusRace = new HashMap<>();
        bonusRace.put(AbilitiesModifierEnum.CHARISMA, 2);
        raceCharacter.setAbilitiesAndBonus(bonusRace);
        HashMap<String, String> descritionRace = new HashMap<>();
        descritionRace.put("Tendencia Comum", "Normalmente Boa, mas alguns deles rejeitam sua linhagem e caem para o mal.");
        raceCharacter.setAdditional_data(descritionRace);

        SubRaceCharacter subRaceCharacter = new SubRaceCharacter();
        subRaceCharacter.setName("Flagelo");
        HashMap<AbilitiesModifierEnum, Integer> bonusSubRace = new HashMap<>();
        bonusSubRace.put(AbilitiesModifierEnum.CONSTITUTION, 1);
        subRaceCharacter.setAbilitiesAndBonus(bonusSubRace);
        HashMap<String, String> descritionSubRace = new HashMap<>();
        descritionSubRace.put("Consumo Radiante", "A partir do nível 3, uma vez por dia pode libertar energia celestial por 1 minuto ou até terminar o efeito com ação bônus. Durante o efeito emana luz brilhante a 3m e luz baixa em mais 3m. Ao final de seu turno você e criaturas a até 3m sofrem ½ seu nível como dano radiante, e uma vez por turno causa +nível dano radiante em um de seus ataques ou magias.");
        subRaceCharacter.setAdditional_data(descritionSubRace);

        raceCharacter.setSubRace(subRaceCharacter);

        return raceCharacter;
    }
}
