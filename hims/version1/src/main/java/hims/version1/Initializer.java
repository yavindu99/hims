package hims.version1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"hims.common", "hims.version1"})
@PropertySource(value = {"classpath:common.properties","classpath:version1.properties"})
public class Initializer {

    public static void main(String[] args) {

        SpringApplication.run(Initializer.class);

    }
}
