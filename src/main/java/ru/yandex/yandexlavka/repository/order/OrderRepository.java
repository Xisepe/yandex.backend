package ru.yandex.yandexlavka.repository.order;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.domain.order.Order;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {
}
