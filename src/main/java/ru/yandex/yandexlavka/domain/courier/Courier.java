package ru.yandex.yandexlavka.domain.courier;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Courier {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    @ElementCollection
    private List<Time> workingHours;
    @ElementCollection
    private List<Integer> regions;
    private CourierType type;

}
