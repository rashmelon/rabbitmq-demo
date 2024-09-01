package org.abdulrahman_rashwan.rabbitmq.service;

import org.abdulrahman_rashwan.rabbitmq.dto.OrderDTO;

public interface OrderService {
    void create(OrderDTO orderDTO);
    void createWithRabbitMQ(OrderDTO orderDTO);
}
