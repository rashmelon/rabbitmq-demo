package org.abdulrahman_rashwan.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbit-messages")
public class MessagePublisherController {
    private final RabbitTemplate rabbitTemplate;

    public MessagePublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public void publishMessage() {
        rabbitTemplate.convertAndSend("TestExchange", "testRoutingKey", "hello from code");
    }
}
