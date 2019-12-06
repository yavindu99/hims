package hims.patunscal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"hims.common","hims.admical","hims.patunscal"})
@PropertySource(value = {"classpath:common.properties","classpath:admical.properties","classpath:patunscal.properties"})
public class Initializer {

    public static void main(String[] args) {

        SpringApplication.run(Initializer.class);

    }

}
