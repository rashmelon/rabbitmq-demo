package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public void reduceItemsAmount(OrderDTO orderDTO) {
        // simulate reducing the amount from inventory
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
