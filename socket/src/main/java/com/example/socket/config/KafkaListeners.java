package com.example.socket.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "notification",
            groupId = "notification_groupId"
    )
    void listener(String data){
        System.out.println("Listener received:" + data);
    }
}
