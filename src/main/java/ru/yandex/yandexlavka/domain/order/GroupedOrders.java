package ru.yandex.yandexlavka.domain.order;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class GroupedOrders {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    @JoinColumn(name = "grouped_orders_id")
    private List<Order> orders;
}
