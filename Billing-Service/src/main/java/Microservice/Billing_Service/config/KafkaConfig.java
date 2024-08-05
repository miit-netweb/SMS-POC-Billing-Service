package Microservice.Billing_Service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic jsonNewTopic(){
            return TopicBuilder.name("billing").build();
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
