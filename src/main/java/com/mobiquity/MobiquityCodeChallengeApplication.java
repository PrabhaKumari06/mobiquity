package com.mobiquity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MobiquityCodeChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobiquityCodeChallengeApplication.class, args);
    }

    @Bean
    public WebClient getWebClientBuilder() {
        return WebClient.builder()
                .codecs(configuration -> configuration.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build();

    }

}
