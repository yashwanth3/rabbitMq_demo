package com.rabbitmqdemo.springboot.controller;

import com.rabbitmqdemo.springboot.dto.User;
import com.rabbitmqdemo.springboot.publisher.JsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private JsonProducer jsonProducer;

    public MessageJsonController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody  User user){

        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RbbitMQ...");

    }
}

