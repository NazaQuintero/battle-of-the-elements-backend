package com.nazareno.battleoftheelements.model.ground;

public class Void implements Ground {
    @Override
    public String getType() {
        return "VACIO";
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 15;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 15;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 15;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 15;
    }
}
