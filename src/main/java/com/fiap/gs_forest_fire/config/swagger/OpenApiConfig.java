package com.fiap.gs_forest_fire.config.swagger;

import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {



    @Bean
    public SwaggerIndexTransformer swaggerIndexTransformer(
            SwaggerUiConfigProperties swaggerUiConfig,
            SwaggerUiOAuthProperties swaggerUiOAuth,
            SwaggerWelcomeCommon swaggerCommon,
            ObjectMapperProvider objectMapperProvider
    ) {
        return new SwaggerStaticFilesInterceptor(
                swaggerUiConfig,
                swaggerUiOAuth,
                swaggerCommon,
                objectMapperProvider
        );
    }

}
