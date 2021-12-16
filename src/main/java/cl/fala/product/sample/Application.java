package cl.fala.product.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

	/**
	 * @author: David Toro Salamanca.
	 * Description: Metodo inicial del MS CRUD para test Falabella.
	 * */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
