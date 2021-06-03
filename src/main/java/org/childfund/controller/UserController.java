package org.childfund.controller;

import org.childfund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/childfund/users")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping(
      path = "/questionnaires",
      consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> addEmployee(@RequestBody String questionnaireJSON) {
    try {
      userService.storeQuestionnaire(questionnaireJSON);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
