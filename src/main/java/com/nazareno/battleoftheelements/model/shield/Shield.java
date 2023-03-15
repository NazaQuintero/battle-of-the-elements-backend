package com.nazareno.battleoftheelements.model.shield;

import com.nazareno.battleoftheelements.model.common.Prototype;

public abstract class Shield implements Prototype {
    public abstract int coverDamage(int damage);
    public abstract Prototype clone();
}
