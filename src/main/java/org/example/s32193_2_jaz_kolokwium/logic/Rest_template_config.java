package org.example.s32193_2_jaz_kolokwium.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Rest_template_config {

    @Bean
    public RestTemplate Rest_template_config() {
        return new RestTemplate();
    }
}
