package com.nazareno.battleoftheelements.model.ground;

public class Path implements Ground {
    @Override
    public String getType() {
        return "PATH";
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 1;
    }
}
