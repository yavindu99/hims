package hims.admical;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"hims.common","hims.admical"})
@PropertySource(value = {"classpath:common.properties","classpath:admical.properties"})
public class Initializer {

    public static void main(String[] args) {

        SpringApplication.run(Initializer.class);

    }
}
