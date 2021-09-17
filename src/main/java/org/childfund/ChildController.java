package org.childfund;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.childfund.models.FormSubmission;
import org.childfund.models.Presence;
import org.childfund.models.Score;
import org.childfund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/childfund/child")
public class ChildController {

  @Autowired private UserService userService;

  @GetMapping(path = "/{id}")
  public String getChildInfo(@PathVariable(value = "id") String childId, Model model) {
    try {
      // todo: Need more than just the latest for scores and presence
      FormSubmission submission = userService.getLatestSubmission(childId);
      List<FormSubmission> childSubmissions = userService.getChildSubmissions(childId);

      List<Score> scores =
          List.of(
              new Score(LocalDate.now().minus(6, ChronoUnit.MONTHS), 50, 60, 70, 20),
              new Score(LocalDate.now().minus(4, ChronoUnit.MONTHS), 60, 65, 70, 25),
              new Score(LocalDate.now().minus(2, ChronoUnit.MONTHS), 75, 50, 75, 35),
              new Score(LocalDate.now().minus(1, ChronoUnit.MONTHS), 90, 70, 75, 40),
              new Score(LocalDate.now(), 90, 75, 80, 50));

      Map<String, Presence> presenceHistory = new HashMap<String, Presence>();
      for (FormSubmission childSubmission : childSubmissions) {
        presenceHistory.put(childSubmission.getSubmissionTime(), childSubmission.getPresence());
      }

      model.addAttribute("child", submission.getChild());
      model.addAttribute("safety", submission.getSafety());
      model.addAttribute("health", submission.getHealth());
      model.addAttribute("education", submission.getEducation());
      model.addAttribute("participation", submission.getParticipation());
      model.addAttribute("presence", submission.getPresence());
      model.addAttribute("scores", scores);
      model.addAttribute("presenceHistory", presenceHistory);

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
  public ResponseEntity<String> getAllChildQuestionnairesById(
      @PathVariable(value = "id") String childId) {
    try {
      String json = userService.getAllChildQuestionnairesById(childId);
      return ResponseEntity.ok(json);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
