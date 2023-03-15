package com.nazareno.battleoftheelements.model.shield;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class MoreThanTwoShields extends Shield {
    @Override
    public int coverDamage(int damage) {
        return (int) (damage - (damage * 0.8));
    }

    @Override
    public Prototype clone() {
        return new MoreThanTwoShields();
    }
}
