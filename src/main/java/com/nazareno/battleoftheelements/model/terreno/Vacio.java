package com.nazareno.battleoftheelements.model.terreno;

public class Vacio implements Ground {
    @Override
    public String getType() {
        return "VACIO";
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAgua() {
        return 15;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaAire() {
        return 15;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaFuego() {
        return 15;
    }

    @Override
    public int obtenerCostoDeEnergiaDadoQuePasaTierra() {
        return 15;
    }
}
