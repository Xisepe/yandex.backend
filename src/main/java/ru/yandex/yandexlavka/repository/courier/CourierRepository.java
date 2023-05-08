package ru.yandex.yandexlavka.repository.courier;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.domain.courier.Courier;

@Repository
public interface CourierRepository extends ListCrudRepository<Courier, Long> {

}
