package com.nazareno.battleoftheelements.model.shield;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.model.common.Prototype;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("TWOPLUS")
public class MoreThanTwoShields extends Shield {

    public MoreThanTwoShields() {
        this.type = "TWOPLUS";
    }

    @Override
    public int coverDamage(int damage) {
        return (int) (damage - (damage * 0.8));
    }

    @Override
    public Prototype clone() {
        return new MoreThanTwoShields();
    }
}
