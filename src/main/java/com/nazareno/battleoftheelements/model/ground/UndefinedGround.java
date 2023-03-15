package com.nazareno.battleoftheelements.model.ground;

public class UndefinedGround implements Ground {
    @Override
    public String getType() {
        return "UNDEFINED";
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 0;
    }
}
