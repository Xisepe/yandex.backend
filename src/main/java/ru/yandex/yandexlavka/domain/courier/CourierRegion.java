package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courier_region")
public class CourierRegion {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "region")
    private int region;
}
