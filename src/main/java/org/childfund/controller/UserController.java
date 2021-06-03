package org.childfund.controller;


import org.childfund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/cfu/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path= "/questionnaires", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addEmployee(
            @RequestBody String questionnaireJSON)
            throws Exception
    {

        String id = userService.create(questionnaireJSON);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
