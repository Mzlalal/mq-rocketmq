package com.mzlalal.mq.producer;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
public class ProducerApplicationTests {

	@Test
	public void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		for (int i = 0; i < 100; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("http://localhost:8091/test/testProducer?age="+i);
			try {
				URL url = new URL(sb.toString());
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.connect();
                conn.getInputStream();
                System.out.println(i);
                conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
