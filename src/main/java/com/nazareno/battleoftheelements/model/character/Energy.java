package com.nazareno.battleoftheelements.model.character;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "energy")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Energy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NonNull private int value;

    public static final int MAX_ENERGY = 20;

    private int getEnergyRecovery(int recovery) {
        return this.value + recovery > MAX_ENERGY ? MAX_ENERGY - this.value : recovery;
    }

    public void incrementValueGivenEnergyRecovery(int recovery) {
        if (this.value < MAX_ENERGY) {
            this.value += getEnergyRecovery(recovery);
        }
    }

    public void decrementValue(int value) {
        if (this.value >= value) {
            this.value -= value;
        } else {
            this.value = 0;
        }
    }
}
