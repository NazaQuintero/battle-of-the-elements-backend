package com.nazareno.battleoftheelements.model.escudo;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class DosEscudos extends Escudo {
    @Override
    public int cubrirDanio(int danio) {
        return (int) (danio - (danio * 0.2));
    }

    @Override
    public Prototype clone() {
        return new DosEscudos();
    }
}
