package com.inin.purecloud.devops;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import java.util.Properties;
import java.util.Random;
import java.util.Date;

/**
 * Created by thawes on 12/28/15.
 */
public class DevopsProducer {
    private Producer producer;
    public DevopsProducer(String brokers) {
        if (brokers.isEmpty()) {
            brokers = "kafka-1.us-east-1.infrastructure.inintca.com,kafka-2.us-east-1.infrastructure.inintca.com,kafka-3.us-east-1.infrastructure.inintca.com";
        }
        Properties props = new Properties();
        props.put("metadata.broker.list", brokers);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "");
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer< String, String>(config);
    }

    public boolean send(String topic, String msg, boolean random) {
        boolean rtn = false;
        Random rnd = new Random();
        long runtime = new Date().getTime();
        String ip = "172.18.0." + rnd.nextInt(255);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, ip, msg);
        producer.send(data);
        return true;
    }
}
