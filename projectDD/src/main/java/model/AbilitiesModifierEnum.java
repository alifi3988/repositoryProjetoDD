package model;

public enum AbilitiesModifierEnum {

    STRENGTH(Strength.class),
    DEXTERITY(Dexterity.class),
    CONSTITUTION(Constitution.class),
    INTELLIGENCE(Intelligence.class),
    WISDOM(Wisdom.class),
    CHARISMA(Charisma.class),
    NONE_ABILITIES(AbilitiesModifier.class),
    ALL_ABILITIES(AbilitiesModifier.class);

    private final Class<? extends AbilitiesModifier> abilittyClass;

    AbilitiesModifierEnum(Class<? extends AbilitiesModifier> abilittyClass) {
        this.abilittyClass = abilittyClass;
    }

    public AbilitiesModifier createAbilityInstance() {
        try {
            return abilittyClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

