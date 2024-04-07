package api.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * - Spring Web
 * - Spring Data JPA
 * - H2 DataBase
 * - OpenFeign
 *
 * @author sauol
 * Descrição: Inspirado no repositorio "lab-padroes-projeto-spring" de Venilton FalvoJr.
 */

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
