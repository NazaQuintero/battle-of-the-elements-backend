package com.nazareno.battleoftheelements.model.terreno;

public class TerrenoIndefinido implements Terreno {
    @Override
    public String getType() {
        return "INDEFINIDO";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 0;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 0;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 0;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 0;
    }
}
