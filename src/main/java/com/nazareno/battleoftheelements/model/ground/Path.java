package com.nazareno.battleoftheelements.model.ground;

import static com.nazareno.battleoftheelements.model.ground.GroundType.PATH;

public class Path implements Ground {
    @Override
    public String getType() {
        return PATH.toString();
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
