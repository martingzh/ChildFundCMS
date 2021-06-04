package org.childfund;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.childfund.models.Child;
import org.childfund.models.Education;
import org.childfund.models.Health;
import org.childfund.models.Score;
import org.childfund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/childfund/child")
public class ChildController {

  @Autowired private UserService userService;

  @GetMapping(path = "/{id}")
  public String getChildInfo(@PathVariable(value = "id") String childId, Model model) {
    try {
      Child child = userService.getChildById(childId);

      Health health =
          new Health(false, "Child has Malaria", "Malaria medication delivered", true, null, null);
      Education education = new Education(Education.SchoolStatus.IN_SCHOOL, null);

      List<Score> scores =
          List.of(
              new Score(LocalDate.now().minus(6, ChronoUnit.MONTHS), 50, 60, 70, 20),
              new Score(LocalDate.now().minus(4, ChronoUnit.MONTHS), 60, 65, 70, 25),
              new Score(LocalDate.now().minus(2, ChronoUnit.MONTHS), 75, 50, 75, 35),
              new Score(LocalDate.now().minus(1, ChronoUnit.MONTHS), 90, 70, 75, 40),
              new Score(LocalDate.now(), 90, 75, 80, 50));

      model.addAttribute("child", child);
      model.addAttribute("health", health);
      model.addAttribute("education", education);
      model.addAttribute("scores", scores);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "child";
  }

  @PostMapping(
      path = "/questionnaires",
      consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Void> storeQuestionnaire(@RequestBody String questionnaireJSON) {
    try {
      userService.storeQuestionnaire(questionnaireJSON);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @GetMapping(
      path = "/questionnaires/{id}",
      consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> getAllQuestionnaires(@PathVariable(value = "id") String childId) {
    try {
      String json = userService.getAllChildQuestionnaires(childId);
      return ResponseEntity.ok(json);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
