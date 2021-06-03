package org.childfund.service;

import java.util.List;

public interface CrudRepository<Child, Community> {

    String create(Child child);

    Child get(String Id);

    List<Child> getAll();

    void update(Child child, String[] params);

    void delete(String Id);
}
