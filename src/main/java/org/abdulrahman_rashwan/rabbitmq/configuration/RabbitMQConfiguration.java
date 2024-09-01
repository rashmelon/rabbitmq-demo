package org.abdulrahman_rashwan.rabbitmq.configuration;

import org.abdulrahman_rashwan.rabbitmq.listener.OrderListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    public static final String ORDER_EXCHANGE = "order-exchange";
    public static final String ORDER_QUEUE = "order-queue";
    public static final String ORDER_ROUTING_KEY = "order.created";

    @Bean
    Queue orderQueue() {
        return QueueBuilder.durable(ORDER_QUEUE).build();
    }

    @Bean
    Exchange orderExchange() {
        return ExchangeBuilder.directExchange(ORDER_EXCHANGE).build();
    }

    @Bean
    Binding orderQueueBinding(Queue orderQueue, Exchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with(ORDER_ROUTING_KEY).noargs();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, Queue orderQueue, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(orderQueue);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);

        return simpleMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(OrderListener orderListener) {
        return new MessageListenerAdapter(orderListener);
    }
}
