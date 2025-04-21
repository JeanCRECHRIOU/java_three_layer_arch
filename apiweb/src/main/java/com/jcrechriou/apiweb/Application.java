package com.jcrechriou.apiweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.jcrechriou"
})
@EnableJpaRepositories(basePackages = "com.jcrechriou.repository")
@EntityScan(basePackages = "com.jcrechriou.entity")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
