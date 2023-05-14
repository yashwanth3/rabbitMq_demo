package com.rabbitmqdemo.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static  final Logger LOGGER= LoggerFactory.getLogger(Producer.class);

    @Value("${rabbitmq.exchange.name}")
    private  String exchange;

    @Value("${rabbitmq.routing.key}")
    private String rountingKey;

    private RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s",message));

        rabbitTemplate.convertAndSend(exchange,rountingKey,message);

    }
}
