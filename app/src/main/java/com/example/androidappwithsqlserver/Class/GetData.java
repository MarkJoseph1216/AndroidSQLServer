package com.example.androidappwithsqlserver.Class;

import com.example.androidappwithsqlserver.Connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    Connection connection;
    String ConnectionResult = "";
    Boolean isSuccess = false;

    public List<Map<String, String>> getData() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connection();
            if (connection == null) {
                ConnectionResult = "Check Your Internet Access!";
            } else {
                String query = "select * from countries";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Map<String, String> dataNum = new HashMap<String, String>();
                    dataNum.put("ID", resultSet.getString("CountryId"));
                    dataNum.put("Country", resultSet.getString("CountryName"));
                    dataNum.put("Capital", resultSet.getString("CapitalCity"));
                    data.add(dataNum);
                }

                ConnectionResult = "Successful!";
                isSuccess = true;
                connection.close();
            }
        } catch (Exception e) {
            isSuccess = true;
            ConnectionResult = e.getMessage();
        }
        return data;
    }
}
