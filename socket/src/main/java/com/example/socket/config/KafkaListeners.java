package com.example.socket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    @Autowired
    public KafkaDynamicTopic kafkaDynamicTopic;

    @KafkaListener(
            topics = "notification",
            groupId = "notification_groupId"
    )
    void listener(String data){
        System.out.println("Listener received:" + data);
    }

    @KafkaListener(
            topics = "newTopicDynamic",
            groupId = "newTopicDynamic_groupId"
    )
    void listener_newTopic(String data){
        System.out.println("New Topic dynamic" + data);
    }
    @KafkaListener(
            topics = "testAnotherTopic",
            groupId = "testAnotherTopic_groupId"
    )
    void listener_newTopic_2(String data){
        System.out.println("Another topic" + data);
    }
}
