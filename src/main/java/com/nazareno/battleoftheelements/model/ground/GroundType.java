package com.nazareno.battleoftheelements.model.ground;

public enum GroundType {
    LAKE {
        @Override
        public String toString() {
            return "LAKE";
        }
    },

    MOUNTAIN {
        @Override
        public String toString() {
            return "MOUNTAIN";
        }
    },

    PATH {
        @Override
        public String toString() {
            return "PATH";
        }
    },

    VOID {
        @Override
        public String toString() {
            return "VOID";
        }
    },

    VOLCANO {
        @Override
        public String toString() {
            return "VOLCANO";
        }
    },

    CLIFF {
        @Override
        public String toString() {
            return "CLIFF";
        }
    }
}
