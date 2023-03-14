package com.nazareno.battleoftheelements.model.personaje;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

public class PersonajeAire extends Personaje {

    public PersonajeAire() {

    }

    public PersonajeAire(PersonajeAire p) {
        super(p);
    }

    @Override
    public Personaje clone() {
        return new PersonajeAire(this);
    }

    @Override
    protected void recibirAtaqueDe(Personaje personajeAtacante) {
        personajeAtacante.atacarAire(this);
    }

    @Override
    protected void atacarAgua(PersonajeAgua personajeAgua) {

    }

    @Override
    protected void atacarFuego(PersonajeFuego personajeFuego) {
        personajeFuego.recibirDanioDadoAtaqueDeAire(this);
    }

    @Override
    protected void atacarAire(PersonajeAire personajeAire) {

    }

    @Override
    protected void atacarTierra(PersonajeTierra personajeTierra) {
        personajeTierra.recibirDanioDadoAtaqueDeAire(this);
    }

    @Override
    protected void recibirDanioDadoAtaqueDeAgua(PersonajeAgua personajeAgua) {
        int valor = this.escudo.cubrirDanio(personajeAgua.getDanioContraAire());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraAire() {
        return 15;
    }

    @Override
    protected int getDanioContraFuego() {
        return 10;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeFuego(PersonajeFuego personajeFuego) {
        int valor = this.escudo.cubrirDanio(personajeFuego.getDanioContraAire());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraAgua() {
        return 0;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeAire(PersonajeAire personajeAire) {

    }

    @Override
    protected int getDanioContraTierra() {
        return 20;
    }

    @Override
    public String getTipo() {
        return "AIRE";
    }

    @Override
    public void pasarPor(Terreno terreno) {
        this.energia.decrementarValor(terreno.obtenerCostoDeEnergiaDadoQuePasaAire());
    }
}
