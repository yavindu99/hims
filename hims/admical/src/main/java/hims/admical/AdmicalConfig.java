package hims.admical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(

        entityManagerFactoryRef = "admicalEntityManagerFactory",
        transactionManagerRef = "admicalTransactionManager",
        basePackages = {"hims.admical"}

)
public class AdmicalConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "admicalDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        return dataSource;

    }

    @Primary
    @Bean(name = "admicalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("admicalDataSource") DataSource dataSource) {

        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder.dataSource(dataSource)
                .packages("hims.admical")
                .persistenceUnit("admical")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "admicalTransactionManager")
    public PlatformTransactionManager admicalTransactionManager(
            @Qualifier("admicalEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }




}
