package za.ac.nwu.ac.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import
        org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.ac.repo.persistence")
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.repo"
})
@EntityScan("za.ac.nwu.ac.domain.persistence")
@PropertySource(value = "classpath:application-test-db.properties")
public class RepositoryConfigTest{
} 