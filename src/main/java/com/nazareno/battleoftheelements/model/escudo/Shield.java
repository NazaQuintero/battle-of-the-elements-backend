package com.nazareno.battleoftheelements.model.escudo;

import com.nazareno.battleoftheelements.model.common.Prototype;

public abstract class Shield implements Prototype {
    public abstract int cubrirDanio(int danio);
    public abstract Prototype clone();
}
