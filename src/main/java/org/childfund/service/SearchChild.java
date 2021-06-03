package org.childfund.service;

import org.childfund.models.Child;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchChild {

    List<Child> findAllChildren();

    List<Child> findAllChildrenByName(String firstName);

    List<Child> findAllChildrenByOtherName(String otherName);

    Child findChildById(String Id);

}
