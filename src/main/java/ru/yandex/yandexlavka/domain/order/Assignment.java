package ru.yandex.yandexlavka.domain.order;

import jakarta.persistence.*;
import lombok.Data;
import ru.yandex.yandexlavka.domain.courier.Courier;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
    private LocalDate date;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "assignment_id")
    private List<GroupedOrders> orders;
}
