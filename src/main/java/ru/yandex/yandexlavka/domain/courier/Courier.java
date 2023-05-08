package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.*;
import lombok.*;
import ru.yandex.yandexlavka.domain.order.Order;

import java.util.List;

@Data
@Entity
public class Courier {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private CourierType type;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "courier"
    )
    private List<WorkingHour> workingHour;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "courier"
    )
    private List<CourierRegion> region;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "courier"
    )
    private List<Order> orders;

}
