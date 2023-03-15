package com.nazareno.battleoftheelements.model.ground;

import static com.nazareno.battleoftheelements.model.ground.GroundType.VOLCANO;

public class Volcano implements Ground {
    @Override
    public String getType() {
        return VOLCANO.toString();
    }

    @Override
    public int getEnergyCostDueToAWaterCharacterPassing() {
        return 2;
    }

    @Override
    public int getEnergyCostDueToAnAirCharacterPassing() {
        return 1;
    }

    @Override
    public int getEnergyCostDueToFireCharacterPassing() {
        return 0;
    }

    @Override
    public int getEnergyCostDueToARockCharacterPassing() {
        return 1;
    }
}
