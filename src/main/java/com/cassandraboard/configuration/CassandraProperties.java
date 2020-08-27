package com.cassandraboard.configuration;

import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
public class CassandraProperties {

    public String cassandraCred;
    public JSONObject cassandraProps;

    public String getCassandraCred() {
        return cassandraCred;
    }

    public void setCassandraCred(String cassandraCred) {
        this.cassandraCred = cassandraCred;
    }

    public JSONObject getCassandraProps() {
        if(cassandraProps == null) {
            cassandraProps= new JSONObject(cassandraCred);
        }
        return cassandraProps;
    }
}
