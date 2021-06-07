package org.childfund.service;

import java.util.List;
import org.childfund.models.Child;
import org.springframework.stereotype.Component;

@Component
public interface SearchChild {

  List<Child> findAllChildren();

  List<Child> findAllChildrenByName(String firstName);

  Child findChildById(String Id);
}
