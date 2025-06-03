package com.devrahul.userservice.consumer;

import com.devrahul.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {

    private UserRepository userRepository;

    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic-json.name}")
    public void listen(Object eventData){
        try {
            System.out.println(eventData);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
