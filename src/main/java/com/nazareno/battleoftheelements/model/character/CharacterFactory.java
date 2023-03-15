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
        // @TODO: create an enum for Character types
        switch (type) {
            case "AGUA":
                character = new WaterCharacter();
                break;
            case "FUEGO":
                character = new FireCharacter();
                break;
            case "TIERRA":
                character = new RockCharacter();
                break;
            case "AIRE":
                character = new AirCharacter();
                break;
            default:
                throw new UnknownCharacterTypeException();
        }

        return character;
    }
}