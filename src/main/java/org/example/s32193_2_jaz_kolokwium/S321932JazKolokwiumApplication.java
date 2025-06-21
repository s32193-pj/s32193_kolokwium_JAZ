package org.example.s32193_2_jaz_kolokwium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class S321932JazKolokwiumApplication {

    public static void main(String[] args) {
        SpringApplication.run(S321932JazKolokwiumApplication.class, args);
    }

}
