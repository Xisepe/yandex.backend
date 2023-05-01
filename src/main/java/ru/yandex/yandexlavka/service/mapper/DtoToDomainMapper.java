package ru.yandex.yandexlavka.service.mapper;

public interface DtoToDomainMapper <I,R>{
    R mapToDomain(I dto);
}
