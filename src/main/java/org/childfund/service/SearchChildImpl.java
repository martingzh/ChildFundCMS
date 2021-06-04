package org.childfund.service;

import java.util.Collections;
import java.util.List;
import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SearchChildImpl implements SearchChild {

  @Autowired private UserService userService;

  @Override
  public List<Child> findAllChildrenByName(String firstName) {
    List<Child> children = userService.getChildrenDataByFirstNameOrOtherName(firstName);
    return !CollectionUtils.isEmpty(children) ? children : Collections.emptyList();
  }

  @Override
  public Child findChildById(String Id) {
    try {
      return userService.getChildById(Id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Child();
  }
}
