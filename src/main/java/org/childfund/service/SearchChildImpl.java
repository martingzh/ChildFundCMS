package org.childfund.service;

import java.util.Collections;
import java.util.List;
import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class SearchChildImpl implements SearchChild {
  @Autowired private UserService userService;

  @Override
  public List<Child> findAllChildren() {
    List<Child> allChildren = userService.getAll();
    return !CollectionUtils.isEmpty(allChildren) ? allChildren : Collections.emptyList();
  }

  @Override
  public List<Child> findAllChildrenByName(String firstName) {
    return Collections.emptyList();
  }

  @Override
  public Child findChildById(String Id) {
    return userService.get(Id);
  }
  // TODO: Error handling
}
