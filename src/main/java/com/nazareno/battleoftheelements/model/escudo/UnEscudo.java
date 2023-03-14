package com.nazareno.battleoftheelements.model.escudo;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class UnEscudo extends Escudo {
    @Override
    public int cubrirDanio(int danio) {
        return (int) (danio - (danio * 0.1));
    }

    @Override
    public Prototype clone() {
        return new UnEscudo();
    }
}
