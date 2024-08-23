package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;

public interface InventoryService {
    void reduceItemsAmount(OrderDTO orderDTO);
}
