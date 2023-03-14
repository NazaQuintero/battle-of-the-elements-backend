package com.nazareno.battleoftheelements.model.personaje;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

public class PersonajeTierra extends Personaje {

    private static final int RECUPERO_DE_ENERGIA = 8;

    public PersonajeTierra() {

    }

    public PersonajeTierra(PersonajeTierra p) {
        super(p);
    }

    @Override
    public Personaje clone() {
        return new PersonajeTierra(this);
    }

    @Override
    public void alimentar() throws PersonajeAlimentadoMasDe3VecesException {
        this.energia.incrementarValorDadoRecuperoDeEnergia(RECUPERO_DE_ENERGIA);
    }

    @Override
    protected void recibirAtaqueDe(Personaje personajeAtacante) {
        personajeAtacante.atacarTierra(this);
    }

    @Override
    protected void atacarAgua(PersonajeAgua personajeAgua) {

    }

    @Override
    protected void atacarFuego(PersonajeFuego personajeFuego) {

    }

    @Override
    protected void atacarAire(PersonajeAire personajeAire) {

    }

    @Override
    protected void atacarTierra(PersonajeTierra personajeTierra) {

    }

    @Override
    protected void recibirDanioDadoAtaqueDeAgua(PersonajeAgua personajeAgua) {

    }

    @Override
    protected int getDanioContraAire() {
        return 10;
    }

    @Override
    protected int getDanioContraFuego() {
        return 0;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeFuego(PersonajeFuego personajeFuego) {

    }

    @Override
    protected int getDanioContraAgua() {
        return 20;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeAire(PersonajeAire personajeAire) {
        int valor = this.escudo.cubrirDanio(personajeAire.getDanioContraTierra());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraTierra() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "TIERRA";
    }

    @Override
    public void pasarPor(Terreno terreno) {
        this.energia.decrementarValor(terreno.obtenerCostoDeEnergiaDadoQuePasaTierra());
    }
}
