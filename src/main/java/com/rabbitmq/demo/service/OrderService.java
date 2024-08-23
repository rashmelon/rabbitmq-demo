package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;

public interface OrderService {
    void create(OrderDTO orderDTO);
    void createWithRabbitMQ(OrderDTO orderDTO);
}
