package org.childfund;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.childfund.models.Child;
import org.childfund.service.SearchChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChildSearchController {

  @Autowired private SearchChild searchChild;

  @RequestMapping(
      value = "/childSearch",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Map> getChildById(
      @RequestParam(name = "searchCriteria") String searchCriteria) {
    List<Map> result = new ArrayList<>();
    Map<String, String> resultJSON = new HashMap<String, String>();
    if (!StringUtils.isEmpty(searchCriteria)) {
      Child child = searchChild.findChildById(searchCriteria);
      if (child != null) {
        resultJSON.put("id", child.getId());
        resultJSON.put("name", child.getFirstName() + " " + child.getOtherName());
        result.add(resultJSON);
        //        String child_hyperlink = "http://localhost:8080/childfund/child/" + childId;
        //        String link =
        //            "<a href=\""
        //                + child_hyperlink
        //                + "\" target=\"_blank\">+"
        //                + child.getFirstName()
        //                + " "
        //                + child.getOtherName()
        //                + "</a>";
      }
      List<Child> children = searchChild.findAllChildrenByName(searchCriteria);
      if (!CollectionUtils.isEmpty(children)) {
        for (Child child1 : children) {
          resultJSON.put("id", child1.getId());
          resultJSON.put("name", child1.getFirstName() + " " + child1.getOtherName());
          result.add(resultJSON);
        }
      }
    }
    Map<String, String> test = new HashMap<>();
    test.put("Name", "Tanvi");
    test.put("Id", "12121");
    result.add(test);
    Map<String, String> test1 = new HashMap<>();
    test1.put("Name", "Tanvi1");
    test1.put("Id", "sdff");
    result.add(test1);
    return result;
  }
}
