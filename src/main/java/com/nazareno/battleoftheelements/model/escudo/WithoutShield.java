package com.nazareno.battleoftheelements.model.escudo;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class WithoutShield extends Shield {
    @Override
    public int cubrirDanio(int danio) {
        return danio;
    }

    @Override
    public Prototype clone() {
        return new WithoutShield();
    }
}
