package com.nazareno.battleoftheelements.model.personaje;

public class PersonajeFactory {
    private static PersonajeFactory instance;

    private PersonajeFactory() {
    }

    public static PersonajeFactory getInstance() {
        if (instance == null) {
            instance = new PersonajeFactory();
        }
        return instance;
    }

    public Personaje getPersonaje(String tipo) throws TipoDePersonajeDesconocidoException {
        Personaje personaje;

        switch (tipo) {
            case "AGUA":
                personaje = new PersonajeAgua();
                break;
            case "FUEGO":
                personaje = new PersonajeFuego();
                break;
            case "TIERRA":
                personaje = new PersonajeTierra();
                break;
            case "AIRE":
                personaje = new PersonajeAire();
                break;
            default:
                throw new TipoDePersonajeDesconocidoException();
        }

        return personaje;
    }
}
