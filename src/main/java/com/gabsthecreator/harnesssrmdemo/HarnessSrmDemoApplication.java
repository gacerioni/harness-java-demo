package com.gabsthecreator.harnesssrmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class HarnessSrmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarnessSrmDemoApplication.class, args);
	}

	@Scheduled(fixedRate = 1000)
	public void scheduleFixedDelayTask() {
		final String uri = "http://localhost:8080/api/v1/harness-modules";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		//System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
	}

}
