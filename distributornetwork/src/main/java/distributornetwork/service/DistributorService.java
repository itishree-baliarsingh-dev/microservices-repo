package distributornetwork.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import distributornetwork.bean.NetworkSettings;
import distributornetwork.dto.Distributor;
import distributornetwork.exception.NotFoundException;
import distributornetwork.repositories.DistributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DistributorService {
    private final DistributorRepository distributorRepository;
    private final NetworkSettings networkSettings;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Transactional(readOnly = true)
    public Distributor findDistributorByDistributorCode(String distributorCode) throws JsonProcessingException {

        Distributor distributor = distributorRepository
                .findByDistributorCode(distributorCode)
                .stream()
                .map(e -> Distributor.of()
                        .distributorCode(e.getDistributorCode())
                        .businessName(e.getDistributorBusinessName())
                        .proprietorName(e.getOwnerName())
                        .contactNo(e.getContactNo())
                        .emailAddress(e.getEmailAddress())
                        .networkSettings(networkSettings)
                        .build())
                .findFirst()
                .orElseThrow(() -> new NotFoundException("distributor does not exist"));

        // ✅ Convert object to JSON (recommended)
        String message = objectMapper.writeValueAsString(distributor);

        // ✅ Send to Kafka
        kafkaTemplate.send("test-topic", distributorCode, message);
        System.out.println("MESSAGE SENT: " + message);

        return distributor;
    }
}
