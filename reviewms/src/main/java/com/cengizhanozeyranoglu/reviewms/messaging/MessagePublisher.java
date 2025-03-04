package com.cengizhanozeyranoglu.reviewms.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessagePublisher {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingKey.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void publish(Long  companyId) {
        String message ="Review create for companyId:" + companyId;
        log.info("Publishing message:"+ message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        log.info("Message sent to RabbitMQ");
    }
}
