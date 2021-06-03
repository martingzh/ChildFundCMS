package org.childfund;

import org.childfund.config.CFConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Import(CFConfiguration.class)
public class Application {

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello World ChildFundCMS!";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
