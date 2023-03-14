package com.nazareno.battleoftheelements.model.terreno;

public class Lago implements Terreno {
    @Override
    public String getType() {
        return "LAGO";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 0;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 2;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 1;
    }
}
