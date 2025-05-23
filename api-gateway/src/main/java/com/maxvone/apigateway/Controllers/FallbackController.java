package com.maxvone.apigateway.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/product")
    public ResponseEntity<String> fallbackProductService(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Product service is currently unavailable. Please try again later.");
    }
}
