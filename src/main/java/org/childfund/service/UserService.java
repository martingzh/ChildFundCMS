package org.childfund.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UserService {

    @Autowired
    private DataSource dataSource;

    public String create(final String payload) {

        Statement stmt = null;
        try {
            stmt = dataSource.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "";
    }

}
