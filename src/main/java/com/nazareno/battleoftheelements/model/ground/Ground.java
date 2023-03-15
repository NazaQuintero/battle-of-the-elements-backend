package com.nazareno.battleoftheelements.model.ground;

public interface Ground {
    String getType();

    int getEnergyCostDueToAWaterCharacterPassing();
    int getEnergyCostDueToAnAirCharacterPassing();
    int getEnergyCostDueToFireCharacterPassing();
    int getEnergyCostDueToARockCharacterPassing();
}
