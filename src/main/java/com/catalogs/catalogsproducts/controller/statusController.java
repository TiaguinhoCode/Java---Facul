package com.catalogs.catalogsproducts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class statusController {

    @GetMapping("/v1/status")
    public String getMethodName() {
        return "Hello word. online";
    }

}
