package org.childfund;

import java.util.ArrayList;
import java.util.List;
import org.childfund.models.Child;
import org.childfund.service.SearchChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/childfund/child")
public class ChildSearchController {

  @Autowired private SearchChild searchChild;

  @GetMapping(path = "/search1/{id}")
  public String getChildById(@PathVariable(value = "id") String id, Model model) {
    Child child = searchChild.findChildById(id);
    model.addAttribute(child);
    return "";
  }

  @GetMapping(path = "/search2/{searchBy}")
  public String getChildByName(@PathVariable(value = "searchBy") String searchBy, Model model) {
    List<Child> children = new ArrayList<>();
    if (!StringUtils.isEmpty(searchBy)) {
      children = searchChild.findAllChildrenByName(searchBy);
    }
    model.addAttribute(children);
    return "";
  }
}
