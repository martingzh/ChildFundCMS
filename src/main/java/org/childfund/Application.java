package org.childfund;

import org.childfund.config.CFConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import(CFConfiguration.class)
<<<<<<< HEAD
public class Application {

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello World ChildFundCMS!";
  }

  @GetMapping("/login")
  public String login(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "login";
=======
public class Application implements WebMvcConfigurer {
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/login").setViewName("login");
>>>>>>> master
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
