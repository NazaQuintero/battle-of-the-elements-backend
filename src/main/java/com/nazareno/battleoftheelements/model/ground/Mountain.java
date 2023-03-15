package com.nazareno.battleoftheelements.model.ground;

import static com.nazareno.battleoftheelements.model.ground.GroundType.MOUNTAIN;

public class Mountain implements Ground {
    @Override
    public String getType() {
        return MOUNTAIN.toString();
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 2;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 0;
    }
}
