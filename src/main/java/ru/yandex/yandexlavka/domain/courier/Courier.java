package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Courier {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private CourierType type;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "courier")
    private List<WorkingHour> workingHour;
    @ElementCollection
    private List<Integer> region;

}
