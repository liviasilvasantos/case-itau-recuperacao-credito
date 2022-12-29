package com.liviasilvasantos.itau.debt.configuration;

import com.liviasilvasantos.itau.debt.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@RequiredArgsConstructor
public class PaymentKafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, CreatePaymentRenegotiationRequest> producerFactory(final KafkaProperties kafkaProperties) {
        val configs = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, CreatePaymentRenegotiationRequest> kafkaTemplate(final ProducerFactory<String, CreatePaymentRenegotiationRequest> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
