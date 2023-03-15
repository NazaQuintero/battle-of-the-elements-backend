package com.nazareno.battleoftheelements.model.shield;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class OneShield extends Shield {
    @Override
    public int coverDamage(int damage) {
        return (int) (damage - (damage * 0.1));
    }

    @Override
    public Prototype clone() {
        return new OneShield();
    }
}
