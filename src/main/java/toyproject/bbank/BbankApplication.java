package toyproject.bbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing // Auditing을 위해 필수
@SpringBootApplication
public class BbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbankApplication.class, args);
	}

}
