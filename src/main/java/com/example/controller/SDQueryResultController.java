package com.example.controller;

import com.example.service.ISDQueryResulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w00990
 * @Date: 2021/4/12
 */
@RestController
public class SDQueryResultController {

    @Autowired
    private ISDQueryResulService isdQueryResulService;


    @GetMapping("/batchSDHandle")
    public void batchSDHandle() {
        isdQueryResulService.batchSDHandle();
    }
}