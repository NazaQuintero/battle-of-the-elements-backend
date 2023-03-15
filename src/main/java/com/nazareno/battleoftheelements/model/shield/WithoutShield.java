package com.nazareno.battleoftheelements.model.shield;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class WithoutShield extends Shield {
    @Override
    public int coverDamage(int damage) {
        return damage;
    }

    @Override
    public Prototype clone() {
        return new WithoutShield();
    }
}
