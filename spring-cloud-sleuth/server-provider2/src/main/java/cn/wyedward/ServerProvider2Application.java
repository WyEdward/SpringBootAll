package cn.wyedward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerProvider2Application.class, args);
	}

}
