package com.cassandraboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CassandraDashboardController {

    @GetMapping("cassandradashboard")
    public String getCassandraDashboard() {
        return "CassandraDashboard";
    }
}
