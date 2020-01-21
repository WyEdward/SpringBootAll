package cn.wyedward;

import cn.wyedward.domain.ConfigBean;
import cn.wyedward.domain.TestConfigBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * 虽然Spring Boot并不推荐我们继续使用xml配置，但如果出现不得不使用xml配置的情况，
 * Spring Boot允许我们在入口类里
 * 通过注解@ImportResource({"classpath:some-application.xml"})来引入xml配置文件。
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
/*@ImportResource({"classpath:some-application.xml"})*/
public class SpringbootConfigApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootConfigApplication.class);
		/*关闭banner图*/
		app.setBannerMode(Banner.Mode.OFF);
		/*不想项目的配置被命令行修改*/
		app.setAddCommandLineProperties(false);
		app.run(args);

	}

}
