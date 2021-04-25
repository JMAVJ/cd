package me.jose.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}

	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping("/random")
	public String random() {
		return "Random Message";
	}
}
