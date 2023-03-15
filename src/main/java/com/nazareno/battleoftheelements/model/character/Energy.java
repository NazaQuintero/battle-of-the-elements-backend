package com.nazareno.battleoftheelements.model.character;

public class Energy {
    private int value;
    public static final int MAX_ENERGY = 20;

    public Energy(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private int getEnergyRecovery(int recovery) {
        return this.value + recovery > MAX_ENERGY ? MAX_ENERGY - this.value : recovery;
    }

    public void incrementValueGivenEnergyRecovery(int recovery) {
        if (this.value < MAX_ENERGY) {
            this.value += getEnergyRecovery(recovery);
        }
    }

    public void decrementValue(int value) {
        if (this.value >= value) {
            this.value -= value;
        } else {
            this.value = 0;
        }
    }
}
