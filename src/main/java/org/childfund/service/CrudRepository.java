package org.childfund.service;

public interface CrudRepository<Child, Community> {

    String Create(Child child);

    Child Retrieve(String firstName);

    void Update(Child child);

    void Delete(String Id);
}
