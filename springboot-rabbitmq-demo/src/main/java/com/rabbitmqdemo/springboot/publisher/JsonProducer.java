package com.rabbitmqdemo.springboot.publisher;

import com.rabbitmqdemo.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static  final Logger LOGGER= LoggerFactory.getLogger(JsonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private  String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private  String routingJsonKey;

    private RabbitTemplate rabbitTemplate;

    public JsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){

        LOGGER.info(String.format("Json message sent->%s",user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);

    }
}
