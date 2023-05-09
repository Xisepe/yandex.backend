package ru.yandex.yandexlavka.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.order.CreateOrderRequest;
import ru.yandex.yandexlavka.dto.order.OrderDto;
import ru.yandex.yandexlavka.request.CompleteOrderRequestDto;
import ru.yandex.yandexlavka.service.order.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Validated
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public List<OrderDto> createOrders(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        return orderService.createOrders(createOrderRequest);
    }
    @GetMapping
    public List<OrderDto> getOrders(
            @RequestParam(required = false, defaultValue = "1") @PositiveOrZero int limit,
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero int offset
    ) {
        return orderService.getOrdersWithLimitAndOffset(limit, offset);
    }
    @GetMapping("/{order_id}")
    public OrderDto getOrderById(@PathVariable(name = "order_id") long orderId) {
        return orderService.getOrderByIdOrThrow(orderId);
    }

    @PostMapping("/complete")
    public List<OrderDto> completeOrders(@RequestBody @Valid CompleteOrderRequestDto completeOrderRequestDto) {
        return orderService.completeOrders(completeOrderRequestDto);
    }



}
