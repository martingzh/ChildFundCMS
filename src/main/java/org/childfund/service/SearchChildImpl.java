package org.childfund.service;

import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SearchChildImpl implements SearchChild {
    @Autowired
    private UserService userService;

    @Override
    public List<Child> findAllChildren() {
        List<Child> allChildren = userService.getAll();
        return !CollectionUtils.isEmpty(allChildren) ? allChildren : Collections.emptyList();
    }

    @Override
    public List<Child> findAllChildrenByName(String firstName) {
        List<Child> allChildren = userService.getAll();
        List<Child> children = new ArrayList<>();
        for (Child child : allChildren) {
            if(child.getFirstName().contains(firstName)){
                children.add(child);
            }
        }
        return !CollectionUtils.isEmpty(children) ? allChildren : Collections.emptyList();
    }

    @Override
    public List<Child> findAllChildrenByOtherName(String otherName) {
        List<Child> allChildren = userService.getAll();
        List<Child> children = new ArrayList<>();
        for (Child child : allChildren) {
            if(child.getOtherName().contains(otherName)){
                children.add(child);
            }
        }
        return !CollectionUtils.isEmpty(children) ? allChildren : Collections.emptyList();
    }

    @Override
    public Child findChildById(String Id) {
        return userService.get(Id);
    }
    //TODO: Error handling
}
