package ru.yandex.yandexlavka.domain.order;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class DeliveryHour {
    @Id
    @GeneratedValue
    private Long id;
    private LocalTime start;
    private LocalTime end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

}
