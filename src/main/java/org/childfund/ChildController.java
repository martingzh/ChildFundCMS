package org.childfund;

import org.childfund.models.Child;
import org.childfund.models.Education;
import org.childfund.models.Health;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class ChildController {
    @GetMapping("/child")
    public String greeting(@RequestParam(name="id", required=true) String id, Model model) {
        // TODO : Lookup child by ID here
        Child child = new Child(
                id,
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
        Health health = new Health(
                false,
                "Child has Malaria",
                "Malaria medication delivered",
                true,
                null,
                null,
                List.of(
                        new Health.Score(LocalDate.now().minus(6, ChronoUnit.MONTHS), 35),
                        new Health.Score(LocalDate.now().minus(4, ChronoUnit.MONTHS), 50),
                        new Health.Score(LocalDate.now().minus(2, ChronoUnit.MONTHS), 75),
                        new Health.Score(LocalDate.now().minus(1, ChronoUnit.MONTHS), 70),
                        new Health.Score(LocalDate.now(), 80)
                )
        );
        Education education = new Education(
                Education.SchoolStatus.IN_SCHOOL,
                List.of(
                        new Education.Score(LocalDate.now().minus(6, ChronoUnit.MONTHS), 50),
                        new Education.Score(LocalDate.now().minus(4, ChronoUnit.MONTHS), 60),
                        new Education.Score(LocalDate.now().minus(2, ChronoUnit.MONTHS), 70),
                        new Education.Score(LocalDate.now().minus(1, ChronoUnit.MONTHS), 70),
                        new Education.Score(LocalDate.now(), 75)
                )
        );
        model.addAttribute("child", child);
        model.addAttribute("health", health);
        model.addAttribute("education", education);
        return "child";
    }
}
