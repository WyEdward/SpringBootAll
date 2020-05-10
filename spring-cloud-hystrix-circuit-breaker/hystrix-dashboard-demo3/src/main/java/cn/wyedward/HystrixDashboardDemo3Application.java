package cn.wyedward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardDemo3Application.class, args);
	}


}
