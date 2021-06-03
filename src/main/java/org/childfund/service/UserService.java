package org.childfund.service;

import org.childfund.models.Child;
import org.childfund.models.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class UserService implements CrudRepository<Child, Community> {

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


    @Override
    public String create(Child child) {
        return null;
    }

    @Override
    public Child get(String Id) {
        return null;
    }

    @Override
    public List<Child> getAll() {
        return null;
    }

    @Override
    public void update(Child child, String[] params) {

    }

    @Override
    public void delete(String Id) {

    }
}
