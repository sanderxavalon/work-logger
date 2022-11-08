package com.sander.worklogger.trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Trigger implements Trigger{

    @Override
    public void init(Connection connection, String s, String s1, String s2, boolean b, int i) throws SQLException {
        Trigger.super.init(connection, s, s1, s2, b, i);
    }

    @Override
    public void fire(Connection connection, Object[] oldRow, Object[] newRow) throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println(newRow[0].toString());
        statement.execute("INSERT INTO CONTENT  VALUES(DEFAULT, \'TRIGGER\', 1, \'TRIGGER\', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())");}

    @Override
    public void close() throws SQLException {
        Trigger.super.close();
    }

    @Override
    public void remove() throws SQLException {
        Trigger.super.remove();
    }

}
