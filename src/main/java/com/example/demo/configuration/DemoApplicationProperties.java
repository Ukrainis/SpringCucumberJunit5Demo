package com.example.demo.configuration;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("java.com.example")
public class DemoApplicationProperties {
    
    @NotNull
    private String baseUrl;

    @NotNull
    private String basePath;
}
