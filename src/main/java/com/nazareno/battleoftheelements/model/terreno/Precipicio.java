package com.nazareno.battleoftheelements.model.terreno;

public class Precipicio implements Ground {
    @Override
    public String getType() {
        return "PRECIPICIO";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 0;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 2;
    }
}
