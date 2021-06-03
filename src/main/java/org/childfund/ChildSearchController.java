package org.childfund;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChildSearchController {

    @RequestMapping(value = "/search",method= RequestMethod.POST)
    public String getChildById(@RequestParam("Id") String Id){
        System.out.println("Testing");
        return "";
    }

    @RequestMapping(value = "/search",method= RequestMethod.POST)
    public String getChildByName(@RequestParam("firstName") String firstName, @RequestParam("otherName") String otherName){
        System.out.println("Testing");
        return "";
    }
}
