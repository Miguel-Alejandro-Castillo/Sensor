package com.atix;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Sensor {

    @Scheduled(fixedRate = 1000)
    public void reportMedition() {

        for (int i = 0 ; i < 2; i++){
            Integer medition = RandomUtils.nextInt();
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Integer> request =  new HttpEntity<>(medition);
            restTemplate.postForObject("http://localhost:8080/SistemaMonitoreo/getMedition", request, Integer.class);
        }

    }
}
