package com.nazareno.battleoftheelements.model.terreno;

public interface Terreno {
    String getType();

    int obtenerCostoDeEnergiaDadoQuePasaAgua();
    int obtenerCostoDeEnergiaDadoQuePasaAire();
    int obtenerCostoDeEnergiaDadoQuePasaFuego();
    int obtenerCostoDeEnergiaDadoQuePasaTierra();
}
