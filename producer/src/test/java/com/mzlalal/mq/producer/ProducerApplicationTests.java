package com.mzlalal.mq.producer;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
public class ProducerApplicationTests {

	@Test
	public void contextLoads() {
		// 测试连接
		for (int i = 0; i < 100; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("http://localhost:8091/test/testProducer?age="+i+"&username=no"+i);
			try {
				URL url = new URL(sb.toString());
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.connect();
                conn.getInputStream();
                conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
