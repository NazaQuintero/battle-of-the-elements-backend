package com.nazareno.battleoftheelements.model.personaje;

import com.nazareno.battleoftheelements.model.common.Prototype;
import com.nazareno.battleoftheelements.model.escudo.Escudo;
import com.nazareno.battleoftheelements.model.escudo.SinEscudo;
import com.nazareno.battleoftheelements.model.terreno.Terreno;

public abstract class Personaje implements Prototype {
    protected String nombre;
    protected Energia energia;
    protected Vida vida;
    protected Escudo escudo = new SinEscudo();

    public Personaje() {
    }
    public Personaje(Personaje p) {
        if (p != null) {
            this.nombre = String.valueOf(p.nombre);
            this.energia = new Energia(p.energia.getValor());
            this.vida = new Vida(p.vida.getValor());
            this.escudo = (Escudo) p.escudo.clone();  //@TODO: hacer un clone para el escudo
        }
    }


    public abstract Personaje clone();

    public Personaje(String nombre, Energia energia, Vida vida) {
        this.energia = energia;
        this.vida = vida;
        this.nombre = nombre;
    }

    public void alimentar() throws PersonajeAlimentadoMasDe3VecesException {
    }

    public int getEnergia() {
        return this.energia.getValor();
    }

    public int getVida() {
        return this.vida.getValor();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEnergia(Energia energia) {
        this.energia = energia;
    }

    public void setVida(Vida vida) {
        this.vida = vida;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public void atacar(Personaje otroPersonaje) {
        otroPersonaje.recibirAtaqueDe(this);
    }

    protected abstract void recibirAtaqueDe(Personaje personajeAtacante);

    protected abstract void atacarAgua(PersonajeAgua personajeAgua);
    protected abstract void atacarFuego(PersonajeFuego personajeFuego);
    protected abstract void atacarAire(PersonajeAire personajeAire);
    protected abstract void atacarTierra(PersonajeTierra personajeTierra);

    protected abstract void recibirDanioDadoAtaqueDeAgua(PersonajeAgua personajeAgua);

    protected abstract int getDanioContraAire();

    protected abstract int getDanioContraFuego();

    protected abstract void recibirDanioDadoAtaqueDeFuego(PersonajeFuego personajeFuego);

    protected abstract int getDanioContraAgua();

    protected abstract void recibirDanioDadoAtaqueDeAire(PersonajeAire personajeAire);

    protected abstract int getDanioContraTierra();

    public abstract String getTipo();

    public Personaje conNombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public Personaje conEnergia(Energia valor) {
        this.setEnergia(valor);
        return this;
    }

    public Personaje conVida(Vida vida) {
        this.setVida(vida);
        return this;
    }

    public abstract void pasarPor(Terreno terreno);
}
