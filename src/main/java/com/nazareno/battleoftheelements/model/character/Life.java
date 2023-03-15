package com.nazareno.battleoftheelements.model.character;

public class Life {
    public static final int MAX_LIFE = 100;
    private int value;

    public Life(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private int getLifeToBeRecovered(int recovery) {
        return this.value + recovery > MAX_LIFE ? MAX_LIFE - this.value : recovery;
    }

    public void decrementValue(int value) {
        this.value -= value;
    }

    public void incrementValueGivenLifeRecovery(int recovery) {
        if (this.value < MAX_LIFE) {
            this.value += getLifeToBeRecovered(recovery);
        }
    }
}
