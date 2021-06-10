package org.childfund;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.childfund.models.Child;
import org.childfund.service.SearchChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/childfund/child")
public class ChildSearchController {

  @Autowired private SearchChild searchChild;

  @RequestMapping(
      value = "/childSearch",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<HashMap<String, String>> getChildById(
      @RequestParam(name = "searchCriteria") String searchCriteria) {
    
    List<HashMap<String, String>> result = new ArrayList<>();
    HashMap<String, String> resultJSON = new HashMap<>();
    
    if (!StringUtils.isEmpty(searchCriteria)) {
      Child child = searchChild.findChildById(searchCriteria);
      if (child != null && child.getId() != null) {
        resultJSON.put("id", child.getId());
        if (child.getOtherName() != null && !child.getOtherName().trim().isEmpty()) {
          resultJSON.put("name", child.getFirstName() + " " + child.getOtherName());
        } else {
          resultJSON.put("name", child.getFirstName());
        }
        result.add(resultJSON);
      }
      
      List<Child> children = searchChild.findAllChildrenByName(searchCriteria);
      if (!CollectionUtils.isEmpty(children)) {
        for (Child child1 : children) {
          if (child1 != null && child1.getId() != null) {
            resultJSON.put("id", child1.getId());
            if (child1.getOtherName() != null && !child1.getOtherName().trim().isEmpty()) {
              resultJSON.put("name", child1.getFirstName() + " " + child1.getOtherName());
            } else {
              resultJSON.put("name", child1.getFirstName());
            }
            result.add(resultJSON);
          }
        }
      }
    }
    return result;
  }
}
