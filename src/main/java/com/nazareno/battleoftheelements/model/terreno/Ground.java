package com.nazareno.battleoftheelements.model.terreno;

public interface Ground {
    String getType();

    int obtenerCostoDeEnergiaDadoQuePasaAgua();
    int obtenerCostoDeEnergiaDadoQuePasaAire();
    int obtenerCostoDeEnergiaDadoQuePasaFuego();
    int obtenerCostoDeEnergiaDadoQuePasaTierra();
}
