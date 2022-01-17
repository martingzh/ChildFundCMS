package org.childfund.controller;

import java.util.List;
import org.childfund.models.Child;
import org.childfund.service.ImmediateAttentionChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChildHomeController {

  private static final int NUMBER_OF_RECENT_DAYS_TO_CHECK = 50;

  @Autowired private ImmediateAttentionChildren immediateAttentionChildren;

  @GetMapping("/childHome")
  public String retrieveChildrenList(Model model) {
    List<Child> children =
        immediateAttentionChildren.getRecentSurveyedChildren(NUMBER_OF_RECENT_DAYS_TO_CHECK);
    model.addAttribute("children", children);
    return "childHome";
  }

  @GetMapping("/immediateAttention")
  public String retrieveChildrenListForImmediateAttention(Model model) {
    List<Child> children =
            immediateAttentionChildren.getRecentSurveyedChildren(NUMBER_OF_RECENT_DAYS_TO_CHECK);
    model.addAttribute("children", children);
    return "immediateAttention";
  }
}
