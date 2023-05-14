package ru.yandex.yandexlavka.repository.order;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.domain.order.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {
    List<Order> findAllByCourierIdAndCompleteTimeBetween(long courierId, LocalDateTime startDate, LocalDateTime endDate);
    List<Order> findAllByStatusOrderByWeight(OrderStatus status);
}
