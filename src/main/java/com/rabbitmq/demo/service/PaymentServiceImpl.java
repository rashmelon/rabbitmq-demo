package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void confirmPayment(OrderDTO orderDTO) {
        // simulate processing the payment info
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
