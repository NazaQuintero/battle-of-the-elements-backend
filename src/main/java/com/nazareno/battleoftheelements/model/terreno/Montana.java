package com.nazareno.battleoftheelements.model.terreno;

public class Montana implements Ground {
    @Override
    public String getType() {
        return "MONTANA";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 2;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 1;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 0;
    }
}
