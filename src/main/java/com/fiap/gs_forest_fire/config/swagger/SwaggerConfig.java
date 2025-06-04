package com.fiap.gs_forest_fire.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${server.servlet.context-path}")
    private String serverBasePath;

    private static final List<String> apiVersions = List.of("v1");

    @Bean
    public OpenAPI customOpenAPI() {
        var apiInfo = new Info().title("Protect Tech API").version("1.0");

        var swaggerVariables = new ServerVariables()
                .addServerVariable("version", new ServerVariable()
                        ._enum(apiVersions)
                        ._default(apiVersions.get(0))
                        .description("API Version"));

        var apiBaseServer = new Server()
                .description("Base URL")
                .url(serverBasePath);

        return new OpenAPI()
                .info(apiInfo)
                .addServersItem(apiBaseServer)
                .components(new io.swagger.v3.oas.models.Components());
    }
}

