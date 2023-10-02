package com.example.SpringBootConditionalTask.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.SpringBootConditionalTask.profile.DevProfile;
import com.example.SpringBootConditionalTask.profile.ProductionProfile;
import com.example.SpringBootConditionalTask.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(prefix = "netology", name = "dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology", name = "dev", havingValue = "false ")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
