package com.nazareno.battleoftheelements.model.shield;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.model.common.Prototype;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("ONE")
public class OneShield extends Shield {

    public OneShield() {
        this.type = "ONE";
    }

    @Override
    public int coverDamage(int damage) {
        return (int) (damage - (damage * 0.1));
    }

    @Override
    public Prototype clone() {
        return new OneShield();
    }
}
