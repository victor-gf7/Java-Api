package br.com.joaovgf.javaapiv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.joaovgf.javaapiv3")
@EntityScan(basePackages = "br.com.joaovgf.javaapiv3.model")
public class JavaApiV3Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiV3Application.class, args);
	}

}
