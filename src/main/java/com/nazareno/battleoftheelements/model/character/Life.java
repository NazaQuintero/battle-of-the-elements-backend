package com.nazareno.battleoftheelements.model.character;

public class Life {
    public static final int VIDA_MAXIMA = 100;
    private int valor;

    public Life(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    private int getRecuperoDeVida(int recupero) {
        return this.valor + recupero > VIDA_MAXIMA ? VIDA_MAXIMA - this.valor : recupero;
    }

    public void decrementarValor(int valor) {
        this.valor -= valor;
    }

    public void incrementarValorDadoRecuperoDeVida(int recupero) {
        if (this.valor < VIDA_MAXIMA) {
            this.valor += getRecuperoDeVida(recupero);
        }
    }
}