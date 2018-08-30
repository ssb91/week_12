package qa.team3.springboot.database.hello.dvdRent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DvdRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdRentApplication.class, args);
	}
}




