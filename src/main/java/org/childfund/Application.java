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
  /*
    @Autowired
    private ThymeleafProperties properties;

    @Value("${spring.thymeleaf.templates_root:}")
    private String templatesRoot;
  */
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("login");
    registry.addViewController("/login").setViewName("login");
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  /*
   @Bean
   public ITemplateResolver defaultTemplateResolver() {
     FileTemplateResolver resolver = new FileTemplateResolver();
     resolver.setSuffix(properties.getSuffix());
     resolver.setPrefix(templatesRoot);
     resolver.setTemplateMode(properties.getMode());
     resolver.setCacheable(properties.isCache());
     return resolver;
   }
  */
}
