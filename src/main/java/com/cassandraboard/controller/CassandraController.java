package com.cassandraboard.controller;

import com.cassandraboard.configuration.CassandraProperties;
import com.cassandraboard.service.CassandraService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CassandraController {
    @Autowired
    CassandraService cassandraService;

    @Autowired
    CassandraProperties cassandraProperties;

    @GetMapping("/query")
    public List<Object> getDataUsingQuery(@RequestParam("node") String node, @RequestParam("query") String query) {
        List<Object> dataByQuery = cassandraService.getDataByQuery(node.trim(), query.trim());
        return dataByQuery;
    }

    @GetMapping("/nodes")
    public List<String> getExistingNodes(){
        JSONObject cassandraProps = cassandraProperties.getCassandraProps();
        Set<String> keys = cassandraProps !=null ? new HashSet<>(cassandraProps.keySet()) : new HashSet<>();
        List<String> nodes= new ArrayList<>();
        for (String key: keys) {
            JSONObject node = (JSONObject) cassandraProps.get(key);
            nodes.add(node.get("name") + "|" +node.get("ipAddress"));
        }
        return nodes;
    }
}
