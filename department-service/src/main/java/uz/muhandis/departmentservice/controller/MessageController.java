package uz.muhandis.departmentservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//For openapi docs
@Tag(name = "Department Service - MessageController", description = "Message Controller Exposes REST APIs for Testing with Department Service")


@RefreshScope
@RestController
public class MessageController {
    @Value("${spring.boot.message}")
    private String message;


    @Operation(summary = "Get Message REST API", description = "This is used to get Message object from the config server by properties file")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")

    @GetMapping("message")
    public String getMessage() {
        return message;
    }
}
