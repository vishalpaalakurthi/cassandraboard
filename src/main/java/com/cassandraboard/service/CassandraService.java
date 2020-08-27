package com.cassandraboard.service;

import com.cassandraboard.configuration.CassandraConfigs;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CassandraService {
    Logger LOG = Logger.getLogger(CassandraService.class.getName());

    @Autowired
    CassandraConfigs cassandraConfigs;

    public List<Object> getDataByQuery(String node, String query) {
        List<Object> mergedResult = new ArrayList<>();
        try {
            Session sessionByNode = cassandraConfigs.getSessionByNode(node);
            //ResultSet resultSet = cassandraConnector.getSession(cassandraProperties.getKeyspaceName()).execute(query);
            ResultSet resultSet = sessionByNode.execute(query);
            List<String> columns = getColumnsFromResultSet(resultSet);
            List<Object> records = getRecordsFromResultSet(resultSet, columns);
            mergedResult.add(columns);
            mergedResult.add(records);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            mergedResult.add(Collections.singletonList("Error Message => " + ex.getMessage()));
        }

        return mergedResult;
    }

    public List<String> getColumnsFromResultSet(ResultSet resultSet) {
        List<String> columns = resultSet.getColumnDefinitions().asList().stream().map(x -> x.getName()).collect(Collectors.toList());
        return columns;
    }

    public List<Object> getRecordsFromResultSet(ResultSet resultSet, List<String > columns) {
        Iterator<Row> iterator = resultSet.iterator();
        List<Object> recordsList = new ArrayList<>();
        while (iterator.hasNext()) {
            Row next = iterator.next();
            List<Object> rowList = new ArrayList<>();
            for (String columnName : columns) {
                Object object = next.getObject(columnName);
                rowList.add(object !=null ? object.toString() : "null");
            }
            recordsList.add(rowList);
        }
        return recordsList;
    }
}
