package inventorymgmt.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMgmtListener {

    @KafkaListener(topics = "test-topic", groupId = "ordergroup2", autoStartup = "true")
    public void processOrder(String order) {
        System.out.println("RECEIVED: " + order);
    }
}
