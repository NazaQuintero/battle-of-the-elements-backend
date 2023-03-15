package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.character.Character;
import com.nazareno.battleoftheelements.model.ground.Void;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;
import com.nazareno.battleoftheelements.model.ground.*;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    Character aRockCharacter;
    Character aWaterCharacter;
    Character anAirCharacter;
    Character aFireCharacter;
    Mountain mountain;
    Cliff cliff;
    Lake lake;
    Volcano volcano;
    Path path;
    Void theVoid;

    @Before
    public void init() {
        aRockCharacter = new RockCharacter().withEnergy(new Energy(20));
        aWaterCharacter = new WaterCharacter().withEnergy(new Energy(20));
        anAirCharacter = new AirCharacter().withEnergy(new Energy(20));
        aFireCharacter = new FireCharacter().withEnergy(new Energy(20));
        mountain = new Mountain();
        cliff = new Cliff();
        lake = new Lake();
        volcano = new Volcano();
        path = new Path();
        theVoid = new Void();
    }

    @Test
    public void aRockCharacterPassesThroughMountain() {
        aRockCharacter.passThrough(mountain);
        assertEquals(20, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughMountain() {
        aWaterCharacter.passThrough(mountain);
        assertEquals(19, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughMountain() {
        aFireCharacter.passThrough(mountain);
        assertEquals(19, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughMountain() {
        anAirCharacter.passThrough(mountain);
        assertEquals(18, anAirCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterPassesThroughCliff() {
        aRockCharacter.passThrough(cliff);
        assertEquals(18, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughCliff() {
        aWaterCharacter.passThrough(cliff);
        assertEquals(19, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughCliff() {
        aFireCharacter.passThrough(cliff);
        assertEquals(19, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughCliff() {
        anAirCharacter.passThrough(cliff);
        assertEquals(20, anAirCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterPassesThroughLake() {
        aRockCharacter.passThrough(lake);
        assertEquals(19, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughLake() {
        aWaterCharacter.passThrough(lake);
        assertEquals(20, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughLake() {
        aFireCharacter.passThrough(lake);
        assertEquals(18, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughLake() {
        anAirCharacter.passThrough(lake);
        assertEquals(19, anAirCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterPassesThroughVolcano() {
        aRockCharacter.passThrough(volcano);
        assertEquals(19, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughVolcano() {
        aWaterCharacter.passThrough(volcano);
        assertEquals(18, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughVolcano() {
        aFireCharacter.passThrough(volcano);
        assertEquals(20, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughVolcano() {
        anAirCharacter.passThrough(volcano);
        assertEquals(19, anAirCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterPassesThroughPath() {
        aRockCharacter.passThrough(path);
        assertEquals(19, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughPath() {
        aWaterCharacter.passThrough(path);
        assertEquals(19, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughPath() {
        aFireCharacter.passThrough(path);
        assertEquals(19, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughPath() {
        anAirCharacter.passThrough(path);
        assertEquals(19, anAirCharacter.getEnergy());
    }

    @Test
    public void aRockCharacterPassesThroughTheVoid() {
        aRockCharacter.passThrough(theVoid);
        assertEquals(5, aRockCharacter.getEnergy());
    }

    @Test
    public void aWaterCharacterPassesThroughTheVoid() {
        aWaterCharacter.passThrough(theVoid);
        assertEquals(5, aWaterCharacter.getEnergy());
    }

    @Test
    public void aFireCharacterPassesThroughTheVoid() {
        aFireCharacter.passThrough(theVoid);
        assertEquals(5, aFireCharacter.getEnergy());
    }

    @Test
    public void anAirCharacterPassesThroughTheVoid() {
        anAirCharacter.passThrough(theVoid);
        assertEquals(5, anAirCharacter.getEnergy());
    }
}
