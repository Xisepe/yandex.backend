package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourierRegion {
    @Id
    @GeneratedValue
    private Long id;
    private int region;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courierId")
    private Courier courier;
}
