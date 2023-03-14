package com.nazareno.battleoftheelements.model.escudo;

import com.nazareno.battleoftheelements.model.common.Prototype;

public class MasDeDosEscudos extends Escudo {
    @Override
    public int cubrirDanio(int danio) {
        return (int) (danio - (danio * 0.8));
    }

    @Override
    public Prototype clone() {
        return new MasDeDosEscudos();
    }
}
