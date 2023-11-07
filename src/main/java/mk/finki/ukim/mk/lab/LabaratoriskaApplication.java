package mk.finki.ukim.mk.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class LabaratoriskaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabaratoriskaApplication.class, args);
    }

}
