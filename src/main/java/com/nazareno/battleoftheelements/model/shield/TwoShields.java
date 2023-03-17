package com.nazareno.battleoftheelements.model.shield;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.model.common.Prototype;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("TWO")
public class TwoShields extends Shield {

    public TwoShields() {
        this.type = "TWO";
    }

    @Override
    public int coverDamage(int damage) {
        return (int) (damage - (damage * 0.2));
    }

    @Override
    public Prototype clone() {
        return new TwoShields();
    }
}
