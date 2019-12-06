package hims.login.version2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"hims.common", "hims.admical", "hims.patunscal", "hims.version2", "hims.version1", "hims.login.version2"})
@PropertySource(value = {"classpath:common.properties", "classpath:admical.properties", "classpath:patunscal.properties", "classpath:version2.properties", "classpath:version1.properties","classpath:login_version2.properties"})
public class Initializer extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Initializer.class);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Initializer.class);
    }


}
