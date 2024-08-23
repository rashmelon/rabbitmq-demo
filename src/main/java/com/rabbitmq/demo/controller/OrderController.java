package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.dto.OrderDTO;
import com.rabbitmq.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String create(@RequestBody OrderDTO orderDTO) {
        orderService.create(orderDTO);

        return "success";
    }

    @PostMapping("rabbitmq")
    public String createWithRabbitMQ(@RequestBody OrderDTO orderDTO) {
        orderService.createWithRabbitMQ(orderDTO);

        return "success";
    }
}
