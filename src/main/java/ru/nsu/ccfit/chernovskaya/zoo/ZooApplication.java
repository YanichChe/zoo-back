package ru.nsu.ccfit.chernovskaya.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.StaffListRepository;

@SpringBootApplication
public class ZooApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);
	}
}
