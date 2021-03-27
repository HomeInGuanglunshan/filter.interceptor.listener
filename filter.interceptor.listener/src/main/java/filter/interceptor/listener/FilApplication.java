package filter.interceptor.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, scanBasePackages = {
		"filter.interceptor.listener" })
public class FilApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilApplication.class, args);
	}
}
