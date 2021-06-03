package org.childfund.service;

import org.childfund.models.Child;
import org.childfund.models.Community;

import java.util.List;

public interface SearchChild extends CrudRepository<Child, Community>{

    public List<Child> findAllChildren();
    public List<Child> findAllChildrenByName(String firstName);
    public Child findChildById(String Id);

}
