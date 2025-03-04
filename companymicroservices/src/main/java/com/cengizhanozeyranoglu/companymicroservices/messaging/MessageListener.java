package com.cengizhanozeyranoglu.companymicroservices.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class MessageListener {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void listen(String message) {
        log.info("Received message:" +  message);
    }
}
