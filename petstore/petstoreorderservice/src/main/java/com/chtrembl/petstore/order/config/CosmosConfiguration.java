package com.chtrembl.petstore.order.config;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "com.chtrembl.petstore.order.repository")
public class CosmosConfiguration extends AbstractCosmosConfiguration {

    @Value("${spring.cloud.azure.cosmos.database}")
    private String cosmosDatabase;
    @Value("${spring.cloud.azure.cosmos.endpoint}")
    private String cosmosEndpoint;
    @Value("${spring.cloud.azure.cosmos.key}")
    private String cosmosKey;

    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
        return new CosmosClientBuilder()
                .endpoint(cosmosEndpoint)
                .key(cosmosKey);
    }

    @Override
    protected String getDatabaseName() {
        return cosmosDatabase;
    }
}
