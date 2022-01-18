package org.childfund.controller;

import org.apache.tomcat.jni.Local;
import org.childfund.models.Child;
import org.childfund.service.ImmediateAttentionChildren;
import org.childfund.service.ImmediateAttentionChildrenImpl;
import org.childfund.models.Partner.LocalPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

  private static final int NUMBER_OF_RECENT_DAYS_TO_CHECK = 50;

  @Autowired private ImmediateAttentionChildren immediateAttentionChildren;
  private ImmediateAttentionChildrenImpl impl;

  @GetMapping("/home")
  public String retrieveChildrenAndPartners(Model model) {
//    List<Child> children =
//        immediateAttentionChildren.getRecentSurveyedChildren(NUMBER_OF_RECENT_DAYS_TO_CHECK);
    impl = new ImmediateAttentionChildrenImpl();
    List<Child> children = impl.createHardCodedImmediateAttentionChildren();
    ArrayList<LocalPartner> partners = new ArrayList<LocalPartner>();
    for (LocalPartner partner : LocalPartner.values()) {
      partners.add(partner);
    }

    model.addAttribute("localPartners", partners);
    model.addAttribute("immediateChildren", children);
    return "home";
  }


}
