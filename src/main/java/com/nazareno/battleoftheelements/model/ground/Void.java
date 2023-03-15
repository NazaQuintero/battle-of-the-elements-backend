package com.nazareno.battleoftheelements.model.ground;

import static com.nazareno.battleoftheelements.model.ground.GroundType.VOID;

public class Void implements Ground {
    @Override
    public String getType() {
        return VOID.toString();
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
