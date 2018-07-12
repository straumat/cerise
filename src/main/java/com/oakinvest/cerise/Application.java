package com.oakinvest.cerise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application.
 */
@SuppressWarnings({"PMD", "checkstyle:hideutilityclassconstructor"})
@SpringBootApplication
public class Application {

    /**
     * Application launcher.
     *
     * @param args parameters.
     */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
