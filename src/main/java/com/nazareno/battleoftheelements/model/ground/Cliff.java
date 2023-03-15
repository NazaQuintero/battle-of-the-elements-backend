package com.nazareno.battleoftheelements.model.ground;

public class Cliff implements Ground {
    @Override
    public String getType() {
        return "CLIFF";
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 2;
    }
}
