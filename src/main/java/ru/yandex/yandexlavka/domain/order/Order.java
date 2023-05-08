package ru.yandex.yandexlavka.domain.order;

import jakarta.persistence.*;
import lombok.Data;
import ru.yandex.yandexlavka.domain.courier.Courier;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private double weight;
    private int region;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "order"
    )
    private List<DeliveryHour> deliveryHours;
    private int cost;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.EMPTY;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courierId")
    private Courier courier;
    private LocalDateTime completeTime;
}
