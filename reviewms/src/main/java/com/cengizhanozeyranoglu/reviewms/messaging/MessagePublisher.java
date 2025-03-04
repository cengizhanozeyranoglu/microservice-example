package com.cengizhanozeyranoglu.reviewms.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public void publish(Long companyId) {
        String message = "New review posted for companyId" + companyId;
        log.info(message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
