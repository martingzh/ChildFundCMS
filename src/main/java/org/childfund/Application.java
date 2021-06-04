package org.childfund;

import org.childfund.config.CFConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import(CFConfiguration.class)
public class Application implements WebMvcConfigurer {
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("index");
    registry.addViewController("/").setViewName("/login");
    registry.addViewController("/login").setViewName("login");
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
