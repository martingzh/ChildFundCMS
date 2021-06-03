package org.childfund.service;

import java.util.List;

public interface CrudRepository<Child, Community> {

    String create(Child child);

    Child get(String firstName);

    List<Child> getAll();

    void update(Child child, String[] params);

    void delete(String Id);
}
