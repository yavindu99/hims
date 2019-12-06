package hims.login.version2.config;

import org.springframework.beans.factory.annotation.Autowired;
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

        entityManagerFactoryRef = "loginVersion2EntityManagerFactory",
        transactionManagerRef = "loginVersion2TransactionManager",
        basePackages = {"hims.login.version2"}

)
public class LoginVersion2Config {

    @Autowired
    private Environment env;


    @Bean(name = "loginVersion2DataSource")
    @ConfigurationProperties(prefix = "login.version2.datasource")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        return dataSource;

    }


    @Bean(name = "loginVersion2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("loginVersion2DataSource") DataSource dataSource) {

        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder.dataSource(dataSource)
                .packages("hims.login.version2")
                .persistenceUnit("login_version2")
                .properties(properties)
                .build();
    }


    @Bean(name = "loginVersion2TransactionManager")
    public PlatformTransactionManager loginTransactionManager(
            @Qualifier("loginVersion2EntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }

}
