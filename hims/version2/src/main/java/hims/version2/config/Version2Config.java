package hims.version2.config;

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

        entityManagerFactoryRef = "version2EntityManagerFactory",
        transactionManagerRef = "version2TransactionManager",
        basePackages = {"hims.version2"}

)
public class Version2Config {

    private Environment env;

    @Bean(name = "version2DataSource")
    @ConfigurationProperties(prefix = "version2.datasource")
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        return dataSource;
    }

    @Bean(name = "version2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("version2DataSource") DataSource dataSource){


        HashMap<String,String> properties = new HashMap();
        properties.put("hibernate.hbm2ddl.auto","update");

        return builder.dataSource(dataSource)
                .packages("hims.version2")
                .persistenceUnit("version2")
                .properties(properties)
                .build();


    }

    @Bean(name = "version2TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("version2EntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);

    }


}
