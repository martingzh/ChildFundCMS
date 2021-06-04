package org.childfund;

import java.util.ArrayList;
import java.util.List;
import org.childfund.models.Child;
import org.childfund.service.SearchChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Controller
public class ChildSearchController {

    @Autowired
    private SearchChild searchChild;

    @GetMapping("/search1")
    public String getChildById(@RequestParam(name = "id") String id, Model model) {
//        childSearch = searchChild.findChildById(id);
//        if (childSearch != null){
//            model.addAttribute("child", childSearch);
//        }
        List<Child> childSearch = new ArrayList<>();
        model.addAttribute("search", childSearch);
        return "search";
    }


//    @GetMapping("/childSearch")
//    public String getChildById(@RequestParam(value = "searchId", defaultValue = "1234") String searchId, Model model){
//        Child child = searchChild.findChildById(searchId);
//
////        if (child != null){
////            model.addAttribute("child", childSearch);
////        }
//        ChildSearch childSearch = new ChildSearch(
//                searchId,
//                "John",
//                "Smith"
//        );
//        model.addAttribute("childSearch", childSearch);
//        return "childSearch";
//    }

    @GetMapping("/search2")
    public String getChildByName(@RequestParam(name = "firstName", required = false) String firstName,
                                 @RequestParam(name = "otherName", required = false) String otherName,
                                 Model model) {
        List<Child> children = new ArrayList<>();
        if (!StringUtils.isEmpty(firstName)) {
            children = searchChild.findAllChildrenByName(firstName);
        }
        if (!StringUtils.isEmpty(otherName)) {
            children = searchChild.findAllChildrenByOtherName(otherName);
        }
        if (!CollectionUtils.isEmpty(children)) {
            model.addAttribute("children", children);
        }
        return "child";
    }
}
