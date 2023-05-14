package com.rabbitmqdemo.springboot.consumer;

import com.rabbitmqdemo.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(JsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public  void consumeJsonMessage(User user){
        LOGGER.info(String.format("Received Json Message -> %s",user.toString()));

    }
}
