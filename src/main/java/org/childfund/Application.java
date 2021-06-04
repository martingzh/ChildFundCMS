package org.childfund;

import org.childfund.config.CFConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Import(CFConfiguration.class)
public class Application {

  @RequestMapping("/")
  String home() {
    return "index";
  }

  @GetMapping("/login")
  public String login(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "login";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
