package com.rabbitmqdemo.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rabbitmqdemo.springboot.publisher.Producer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RbbitMQ...");

    }
}
