package com.fiap.gs_forest_fire.specs.error;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@ApiResponse(
        responseCode = "400",
        description = "${springdoc.swagger-config.responses.error.400}",
        content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(
                        example = "{\"timestamp\": \"2025-05-23T12:08:05.801+00:00\", \"status\": \"400\", \"error\": \"Bad Request\", \"path\": \"/user\" }"
                )
        )
)
public @interface ApiResponseBadRequest {
}
