package com.nazareno.battleoftheelements.model.terreno;

public class Camino implements Terreno {
    @Override
    public String getType() {
        return "CAMINO";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 1;
    }
}
