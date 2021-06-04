package org.childfund.service;

import java.util.List;
import org.childfund.models.Child;
import org.springframework.stereotype.Component;

@Component
public interface SearchChild {

  List<Child> findAllChildrenByName(String firstName);

  List<Child> findAllChildrenByOtherName(String otherName);

  Child findChildById(String Id);
}
