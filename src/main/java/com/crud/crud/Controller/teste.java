package com.crud.crud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class teste {

    @GetMapping(path = "/teste")
    public String testar(){
        return"OK";
    }

}
