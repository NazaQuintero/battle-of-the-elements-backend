package com.nazareno.battleoftheelements.model.shield;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.model.common.Prototype;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("NONE")
public class WithoutShield extends Shield {

    public WithoutShield() {
        this.type = "NONE";
    }

    @Override
    public int coverDamage(int damage) {
        return damage;
    }

    @Override
    public Prototype clone() {
        return new WithoutShield();
    }
}
