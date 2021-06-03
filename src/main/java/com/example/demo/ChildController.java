package com.example.demo;

import com.example.demo.models.Child;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ChildController {
    @GetMapping("/child")
    public String greeting(@RequestParam(name="id", required=true) String id, Model model) {
        // TODO : Lookup child by ID here
        Child child = new Child(id,
                "John",
                "Smith",
                7,
                LocalDate.now(),
                "male",
                "LS1",
                "VillageName",
                "Public",
                "2",
                "Family Group",
                LocalDateTime.now()
        );
        model.addAttribute("child", child);
        return "child";
    }
}
