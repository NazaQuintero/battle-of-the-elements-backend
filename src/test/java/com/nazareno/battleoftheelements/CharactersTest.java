package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.shield.TwoShields;
import com.nazareno.battleoftheelements.model.shield.MoreThanTwoShields;
import com.nazareno.battleoftheelements.model.shield.OneShield;
import com.nazareno.battleoftheelements.model.character.Character;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;

import static com.nazareno.battleoftheelements.model.character.CharacterType.*;
import static org.junit.Assert.assertEquals;

public class CharactersTest {

    Character aWaterCharacter;
    Character aWaterCharacterWith20Energy;
    Character aRockCharacter;
    Character aFireCharacter;
    Character anAirCharacter;

    @Before
    public void init() throws UnknownCharacterTypeException {
        CharacterFactory factory = CharacterFactory.getInstance();

        int initialEnergyValue = 0;
        int initialLifeValue = 100;

        aWaterCharacter = factory.getCharacter(WATER.toString())
                .named("Nami")
                .withEnergy(new Energy(initialEnergyValue))
                .withLife(new Life(initialLifeValue));

        aWaterCharacterWith20Energy = aWaterCharacter.clone().withEnergy(new Energy(20));

        aRockCharacter = factory.getCharacter(ROCK.toString())
                .named("Blitzcrank")
                .withEnergy(new Energy(initialEnergyValue))
                .withLife(new Life(initialLifeValue));

        aFireCharacter = factory.getCharacter(FIRE.toString())
                .named("Wukong")
                .withEnergy(new Energy(initialEnergyValue))
                .withLife(new Life(initialLifeValue));

        anAirCharacter = factory.getCharacter(AIR.toString())
                .named("Ashe")
                .withEnergy(new Energy(initialEnergyValue))
                .withLife(new Life(initialLifeValue));
    }

    @Test
    public void aWaterCharacterIsFed() throws CharacterFedMoreThan3TimesException {
        aWaterCharacter.feed();
        assertEquals(10, aWaterCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterIsFed3Times() throws CharacterFedMoreThan3TimesException {
        feed3Times(aWaterCharacter);
        assertEquals(20, aWaterCharacter.getEnergy());
    }

    private void feed3Times(Character character) throws CharacterFedMoreThan3TimesException {
        for (int i = 0; i < 3; i++) {
            character.feed();
        }
    }

    @Test(expected = CharacterFedMoreThan3TimesException.class)
    public void aWaterCharacterIsFedMoreThan3Times() throws CharacterFedMoreThan3TimesException {
        feed3Times(aWaterCharacter);
        aWaterCharacter.feed();
    }

    @Test
    public void aRockCharacterIsFed() throws CharacterFedMoreThan3TimesException {
        aRockCharacter.feed();
        assertEquals(8, aRockCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterIsFed2Times() throws CharacterFedMoreThan3TimesException {
        aRockCharacter.feed();
        aRockCharacter.feed();
        assertEquals(16, aRockCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterIsFed() throws CharacterFedMoreThan3TimesException {
        aFireCharacter.withLife(new Life(10));
        aFireCharacter.feed();
        assertEquals(25, aFireCharacter.getLife());
    }

    @Test
    public void aFireCharacterIsFed9Times() throws CharacterFedMoreThan3TimesException {
        for (int i = 0; i < 3; i++) {
            feed3Times(aFireCharacter);
        }
        assertEquals(100, aFireCharacter.getLife());
    }

    @Test
    public void anAirCharacterIsFed() throws CharacterFedMoreThan3TimesException {
        anAirCharacter.withEnergy(new Energy(25));
        anAirCharacter.feed();
        assertEquals(25, anAirCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterAttacksAnAirCharacterWithoutShield() {
        aWaterCharacterWith20Energy.attack(anAirCharacter);
        assertEquals(80, anAirCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAnAirCharacterWithOneShield() {
        anAirCharacter.setShield(new OneShield());
        aWaterCharacterWith20Energy.attack(anAirCharacter);
        assertEquals(82, anAirCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAnAirCharacterWithTwoShields() {
        anAirCharacter.setShield(new TwoShields());
        aWaterCharacterWith20Energy.attack(anAirCharacter);
        assertEquals(84, anAirCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAnAirCharacterWithMoreThanTwoShields() {
        anAirCharacter.setShield(new MoreThanTwoShields());
        aWaterCharacterWith20Energy.attack(anAirCharacter);
        assertEquals(96, anAirCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAFireCharacterWithoutShield() {
        aWaterCharacterWith20Energy.attack(aFireCharacter);
        assertEquals(70, aFireCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAFireCharacterWithOneShield() {
        aFireCharacter.setShield(new OneShield());
        aWaterCharacterWith20Energy.attack(aFireCharacter);
        assertEquals(73, aFireCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAFireCharacterWithTwoShields() {
        aFireCharacter.setShield(new TwoShields());
        aWaterCharacterWith20Energy.attack(aFireCharacter);
        assertEquals(76, aFireCharacter.getLife());
    }

    @Test
    public void aWaterCharacterAttacksAFireCharacterWithMoreThanTwoShields() {
        aFireCharacter.setShield(new MoreThanTwoShields());
        aWaterCharacterWith20Energy.attack(aFireCharacter);
        assertEquals(94, aFireCharacter.getLife());
    }

    @Test
    public void aFireCharacterAttacksAnotherFireCharacterWithoutShield() {
        aFireCharacter.clone().attack(aFireCharacter);
        assertEquals(80, aFireCharacter.getLife());
    }

    @Test
    public void aFireCharacterAttacksAnAirCharacterWithoutShield() {
        aFireCharacter.attack(anAirCharacter);
        assertEquals(70, anAirCharacter.getLife());
    }

    @Test
    public void aFireCharacterAttacksAWaterCharacterWithoutShield() {
        aFireCharacter.attack(aWaterCharacter);
        assertEquals(90, aWaterCharacter.getLife());
    }

    @Test
    public void anAirCharacterAttacksARockCharacterWithoutShield() {
        anAirCharacter.attack(aRockCharacter);
        assertEquals(80, aRockCharacter.getLife());
    }

    @Test
    public void anAirCharacterAttacksAFireCharacterWithoutShield() {
        anAirCharacter.attack(aFireCharacter);
        assertEquals(90, aFireCharacter.getLife());
    }
}
