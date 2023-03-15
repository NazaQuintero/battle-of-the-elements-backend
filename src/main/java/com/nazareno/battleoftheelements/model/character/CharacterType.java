package com.nazareno.battleoftheelements.model.character;

public enum CharacterType {
    WATER {
        @Override
        public String toString() {
            return "WATER";
        }
    },

    ROCK {
        @Override
        public String toString() {
            return "ROCK";
        }
    },

    FIRE {
        @Override
        public String toString() {
            return "FIRE";
        }
    },

    AIR {
        @Override
        public String toString() {
            return "AIR";
        }
    }
}
