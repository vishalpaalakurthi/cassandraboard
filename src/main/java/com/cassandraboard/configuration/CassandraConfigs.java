package com.cassandraboard.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class CassandraConfigs {

    Map<String, Session> cassandraSession = new HashMap<>();

    @Autowired
    CassandraProperties cassandraProperties;

    @PostConstruct
    public void configureSessions(){
        JSONObject cassJsonObject = cassandraProperties.getCassandraProps();
        if(cassJsonObject != null) {
            Set<String> keys =  new HashSet<>(cassJsonObject.keySet());
            for(String key : keys) {
                JSONObject config = (JSONObject) cassJsonObject.get(key);
                String serverName = String.valueOf(config.get("name"));
                String ipAddress = String.valueOf(config.get("ipAddress"));
                String userName = String.valueOf(config.get("userName"));
                String password = String.valueOf(config.get("password"));
                Session session = getSession(ipAddress, userName, password);
                cassandraSession.put(serverName, session);
            }
        }
    }

    public Session getSession(String ipAddress, String userName, String password) {
        Cluster cluster = Cluster.builder().addContactPoint(ipAddress).withCredentials(userName, password)
                .withPort(9042)
                .withoutJMXReporting().build();
        return cluster.connect("ace2three");
    }

    public Session getSessionByNode(String serverName) {
        return cassandraSession.get(serverName);
    }

}
