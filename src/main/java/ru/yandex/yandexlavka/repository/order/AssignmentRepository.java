package ru.yandex.yandexlavka.repository.order;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.domain.order.Assignment;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AssignmentRepository extends ListCrudRepository<Assignment, Long> {
    List<Assignment> findAllByDate(LocalDate date);
    List<Assignment> findAllByDateAndCourierId(LocalDate date, long id);
}
