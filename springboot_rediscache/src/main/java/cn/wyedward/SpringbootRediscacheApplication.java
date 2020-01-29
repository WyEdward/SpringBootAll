package cn.wyedward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching   //开启缓存功能 用这个之前导入cache依赖
public class SpringbootRediscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRediscacheApplication.class, args);
	}

}
