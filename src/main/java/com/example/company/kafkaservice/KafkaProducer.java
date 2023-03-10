package com.example.company.kafkaservice;

import com.example.company.constant.KafkaConstant;
import com.example.company.model.Countries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger log = LogManager.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Countries> kafkaTemplate;

    public void sendMsg(Countries countries){

        log.info("Message sent : {}", countries.toString());
        kafkaTemplate.send(KafkaConstant.TOPIC_NAME, countries);
    }

}
