package org.childfund;

import org.childfund.models.Child;
import org.childfund.models.Education;
import org.childfund.models.Health;
import org.childfund.models.Score;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                null
        );
        Education education = new Education(
                Education.SchoolStatus.IN_SCHOOL
        );

        List<Score> scores = List.of(
                new Score(LocalDate.now().minus(6, ChronoUnit.MONTHS), 50, 60, 70, 20),
                new Score(LocalDate.now().minus(4, ChronoUnit.MONTHS), 60, 65, 70, 25),
                new Score(LocalDate.now().minus(2, ChronoUnit.MONTHS), 75, 50, 75, 35),
                new Score(LocalDate.now().minus(1, ChronoUnit.MONTHS), 90, 70, 75, 40),
                new Score(LocalDate.now(), 90, 75, 80, 50)
        );

        model.addAttribute("child", child);
        model.addAttribute("health", health);
        model.addAttribute("education", education);
        model.addAttribute("scores", scores);
        return "child";
    }
}
