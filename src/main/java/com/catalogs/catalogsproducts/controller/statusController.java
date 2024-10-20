package com.catalogs.catalogsproducts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/status")
public class statusController {
    // method

    @GetMapping
    public String helloWord() {
        return "Hello word!";
    }

}
