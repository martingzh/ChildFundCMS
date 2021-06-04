package org.childfund.controller;

import org.childfund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/childfund/child")
public class UserController {

  @Autowired private UserService userService;

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
  public ResponseEntity<String> getQuestionnaire(@PathVariable(value = "id") String childId) {
    try {
      String json = userService.getQuestionnaire(childId);
      return ResponseEntity.ok(json);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
