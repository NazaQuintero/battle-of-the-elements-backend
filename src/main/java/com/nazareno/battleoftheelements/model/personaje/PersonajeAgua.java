package com.nazareno.battleoftheelements.model.personaje;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

public class PersonajeAgua extends Personaje {

    private int vecesAlimentado = 0;
    public static final int RECUPERO_DE_ENERGIA = 10;

    public PersonajeAgua() {

    }

    public PersonajeAgua(PersonajeAgua p) {
        super(p);
    }

    @Override
    public Personaje clone() {
        return new PersonajeAgua(this);
    }

    @Override
    public void alimentar() throws PersonajeAlimentadoMasDe3VecesException {
        this.vecesAlimentado++;
        if (this.vecesAlimentado > 3)
            throw new PersonajeAlimentadoMasDe3VecesException();
        this.energia.incrementarValorDadoRecuperoDeEnergia(RECUPERO_DE_ENERGIA);
    }

    @Override
    public void atacar(Personaje otroPersonaje) {
        otroPersonaje.recibirAtaqueDe(this);
    }

    @Override
    protected void recibirAtaqueDe(Personaje personajeAtacante) {
        personajeAtacante.atacarAgua(this);
    }

    @Override
    protected void atacarAgua(PersonajeAgua personajeAgua) {

    }

    @Override
    protected void atacarFuego(PersonajeFuego personajeFuego) {
        personajeFuego.recibirDanioDadoAtaqueDeAgua(this);
    }

    @Override
    protected void atacarAire(PersonajeAire personajeAire) {
        personajeAire.recibirDanioDadoAtaqueDeAgua(this);
    }

    @Override
    protected void atacarTierra(PersonajeTierra personajeTierra) {

    }

    @Override
    protected void recibirDanioDadoAtaqueDeAgua(PersonajeAgua personajeAgua) {

    }

    @Override
    protected int getDanioContraAire() {
        return 20;
    }

    @Override
    protected int getDanioContraFuego() {
        return 30;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeFuego(PersonajeFuego personajeFuego) {
        int valor = this.escudo.cubrirDanio(personajeFuego.getDanioContraAgua());
        this.vida.decrementarValor(valor);
    }

    @Override
    protected int getDanioContraAgua() {
        return 20;
    }

    @Override
    protected void recibirDanioDadoAtaqueDeAire(PersonajeAire personajeAire) {

    }

    @Override
    protected int getDanioContraTierra() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "AGUA";
    }

    @Override
    public void pasarPor(Terreno terreno) {
        this.energia.decrementarValor(terreno.obtenerCostoDeEnergiaDadoQuePasaAgua());
    }
}
