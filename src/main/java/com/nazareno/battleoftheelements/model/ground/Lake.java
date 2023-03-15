package com.nazareno.battleoftheelements.model.ground;

public class Lake implements Ground {
    @Override
    public String getType() {
        return "LAKE";
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 2;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 1;
    }
}