package com.nazareno.battleoftheelements.model.personaje;

public class Energia {
    private int valor;
    public static final int ENERGIA_MAXIMA = 20;

    public Energia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    private int getRecuperoDeEnergia(int recupero) {
        return this.valor + recupero > ENERGIA_MAXIMA ? ENERGIA_MAXIMA - this.valor : recupero;
    }

    public void incrementarValorDadoRecuperoDeEnergia(int recupero) {
        if (this.valor < ENERGIA_MAXIMA) {
            this.valor += getRecuperoDeEnergia(recupero);
        }
    }

    public void decrementarValor(int energia) {
        if (this.valor >= energia) {
            this.valor -= energia;
        } else {
            this.valor = 0;
        }
    }
}
