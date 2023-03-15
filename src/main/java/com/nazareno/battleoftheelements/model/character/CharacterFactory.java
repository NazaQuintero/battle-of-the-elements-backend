package com.nazareno.battleoftheelements.model.character;

public class CharacterFactory {
    private static CharacterFactory instance;

    private CharacterFactory() {
    }

    public static CharacterFactory getInstance() {
        if (instance == null) {
            instance = new CharacterFactory();
        }
        return instance;
    }

    public Character getCharacter(String type) throws UnknownCharacterTypeException {
        Character character;
        try {
            CharacterType characterType = CharacterType.valueOf(type);
            character = switch (characterType) {
                case WATER -> new WaterCharacter();
                case FIRE -> new FireCharacter();
                case ROCK -> new RockCharacter();
                case AIR -> new AirCharacter();
            };
        } catch (Exception e) {
            throw new UnknownCharacterTypeException();
        }
        return character;
    }
}
