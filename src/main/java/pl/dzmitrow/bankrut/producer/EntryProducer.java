package pl.dzmitrow.bankrut.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.dzmitrow.bankrut.model.Entry;

@Slf4j
@Component
public class EntryProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${cloudkarafka.entriesTopic}")
    private String topic;

    EntryProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Entry entry) {
        try {
            this.kafkaTemplate.send(topic, objectMapper.writeValueAsString(entry));
            log.info("Sent sample message [" + entry + "] to " + topic);
        } catch (JsonProcessingException e) {
            log.error("Failed to map entry {}", entry, e);
        }
    }


}
