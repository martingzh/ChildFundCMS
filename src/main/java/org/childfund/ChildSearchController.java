package org.childfund;

import org.childfund.models.Child;
import org.childfund.service.SearchChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChildSearchController {

    @Autowired
    private SearchChild searchChild;

    @GetMapping("/search1")
    public String getChildById(@RequestParam("Id") String Id, Model model){
        Child child = searchChild.findChildById(Id);
        model.addAttribute(child);
        return "";
    }

    @GetMapping("/search2")
    public String getChildByName(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "otherName", required = false) String otherName,
                                 Model model){
        List<Child> children = new ArrayList<>();
        if (!StringUtils.isEmpty(firstName)){
            children = searchChild.findAllChildrenByName(firstName);
        }
        if (!StringUtils.isEmpty(otherName)){
            children = searchChild.findAllChildrenByOtherName(otherName);
        }
        model.addAttribute(children);
        return "";
    }
}
