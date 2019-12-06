package hims.patunscal;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(

        basePackages = {"hims.patunscal"},
        mongoTemplateRef = "patunscalTemplate"

)
public class PatunscalConfig {

    private PatunscalProperties patunscalProperties;

    @Autowired
    public PatunscalConfig(PatunscalProperties patunscalProperties) {
        this.patunscalProperties = patunscalProperties;
    }

    @Bean(name = "patunscalTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(factory(patunscalProperties));
    }

    @Bean
    public MongoDbFactory factory(PatunscalProperties patunscalProperties) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(patunscalProperties.getHost(), patunscalProperties.getPort()),
                patunscalProperties.getDatabase());
    }

}
