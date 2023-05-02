package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class WorkingHour {
    @Id
    @GeneratedValue
    private Long id;
    private LocalTime start;
    private LocalTime end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courierId")
    private Courier courier;

}
