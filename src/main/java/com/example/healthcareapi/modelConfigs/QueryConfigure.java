package com.example.healthcareapi.modelConfigs;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(namedQueriesLocation = "src/main/resources/dbhelper/jpahelper.properties")
public class QueryConfigure {
}
