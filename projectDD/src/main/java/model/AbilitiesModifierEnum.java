package model;

import base.AbilitiesScoreAndModifier;

public enum AbilitiesModifierEnum {

    STRENGTH(Strength.class),
    DEXTERITY(Dexterity.class),
    CONSTITUTION(Constitution.class),
    INTELLIGENCE(Intelligence.class),
    WISDOM(Wisdom.class),
    CHARISMA(Charisma.class),
    NONE_ABILITIES(AbilitiesScoreAndModifier.class),
    ALL_ABILITIES(AbilitiesScoreAndModifier.class);

    private final Class<? extends AbilitiesScoreAndModifier> abilittyClass;

    AbilitiesModifierEnum(Class<? extends AbilitiesScoreAndModifier> abilittyClass) {
        this.abilittyClass = abilittyClass;
    }

    public AbilitiesScoreAndModifier createAbilityInstance() {
        try {
            return abilittyClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

