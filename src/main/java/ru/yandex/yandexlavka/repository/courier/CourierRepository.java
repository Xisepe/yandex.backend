package ru.yandex.yandexlavka.repository.courier;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.domain.courier.Courier;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Long> {

}
