package hims.version1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

        entityManagerFactoryRef = "version1EntityManagerFactory",
        transactionManagerRef = "version1TransactionManager",
        basePackages = {"hims.version1"}

)
public class Version1Config {


    private Environment env;

    @Bean(name = "version1DataSource")
    @ConfigurationProperties(prefix = "version1.datasource")
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        return dataSource;
    }

    @Bean(name = "version1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("version1DataSource") DataSource dataSource){


        HashMap<String,String> properties = new HashMap();
        properties.put("hibernate.hbm2ddl.auto","update");

        return builder.dataSource(dataSource)
                .packages("hims.version1")
                .persistenceUnit("version1")
                .properties(properties)
                .build();


    }

    @Bean(name = "version1TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("version1EntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);

    }


}
