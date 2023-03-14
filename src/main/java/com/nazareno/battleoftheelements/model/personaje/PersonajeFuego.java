package com.nazareno.battleoftheelements.model.personaje;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

public class PersonajeFuego extends Personaje {

    public static final int RECUPERO_DE_VIDA = 15;

    public PersonajeFuego(String nombre, Energia energia, Vida vida) {
        super(nombre, energia, vida);
    }

    public PersonajeFuego() {

    }

    public PersonajeFuego(PersonajeFuego p) {
        super(p);
    }

    @Override
    public Personaje clone() {
        return new PersonajeFuego(this);
    }

    @Override
    public void alimentar() throws PersonajeAlimentadoMasDe3VecesException {

        this.vida.incrementarValorDadoRecuperoDeVida(RECUPERO_DE_VIDA);
    }

    @Override
    protected void recibirAtaqueDe(Personaje personajeAtacante) {
        personajeAtacante.atacarFuego(this);
    }

    @Override
    protected void atacarAgua(PersonajeAgua personajeAgua) {
        personajeAgua.recibirDanioDadoAtaqueDeFuego(this);
    }

    @Override
    protected void atacarFuego(PersonajeFuego personajeDeFuegoAtacado) {
        personajeDeFuegoAtacado.recibirDanioDadoAtaqueDeFuego(this);
    }

    @Override
    protected void atacarAire(PersonajeAire personajeAire) {
        personajeAire.recibirDanioDadoAtaqueDeFuego(this);
    }

    @Override
    protected void atacarTierra(PersonajeTierra personajeTierra) {

    }

    @Override
    protected void recibirDanioDadoAtaqueDeAgua(PersonajeAgua personajeAgua) {
        int valor = this.escudo.cubrirDanio(personajeAgua.getDanioContraFuego());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraAire() {
        return 30;
    }

    @Override
    protected int getDanioContraFuego() {
        return 20;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeFuego(PersonajeFuego personajeFuegoAtacante) {
        int valor = this.escudo.cubrirDanio(personajeFuegoAtacante.getDanioContraFuego());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraAgua() {
        return 10;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeAire(PersonajeAire personajeAire) {
        int valor = this.escudo.cubrirDanio(personajeAire.getDanioContraFuego());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraTierra() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "FUEGO";
    }

    @Override
    public void pasarPor(Terreno terreno) {
        this.energia.decrementarValor(terreno.obtenerCostoDeEnergiaDadoQuePasaFuego());
    }
}
