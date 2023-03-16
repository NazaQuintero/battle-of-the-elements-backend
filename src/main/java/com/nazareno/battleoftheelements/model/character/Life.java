package com.nazareno.battleoftheelements.model.character;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "life")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Life {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NonNull private int value;

    public static final int MAX_LIFE = 100;

    private int getLifeToBeRecovered(int recovery) {
        return this.value + recovery > MAX_LIFE ? MAX_LIFE - this.value : recovery;
    }

    public void decrementValue(int value) {
        this.value -= value;
    }

    public void incrementValueGivenLifeRecovery(int recovery) {
        if (this.value < MAX_LIFE) {
            this.value += getLifeToBeRecovered(recovery);
        }
    }
}
