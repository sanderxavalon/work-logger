package com.sander.worklogger.trigger;

import org.h2.tools.TriggerAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2TriggerExtend extends TriggerAdapter {

    @Override
    public void fire(Connection connection, ResultSet resultSet, ResultSet resultSet1) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select 1");
    }

}
