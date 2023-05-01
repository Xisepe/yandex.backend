package ru.yandex.yandexlavka.service.mapper;

public interface DomainToDtoMapper <I,R>{
    R mapToDto(I domain);
}
