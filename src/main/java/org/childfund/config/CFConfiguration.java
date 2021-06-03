package org.childfund.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.childfund"})
public class CFConfiguration {

  @Bean
  public BasicDataSource dataSource() throws URISyntaxException {

    BasicDataSource basicDataSource = new BasicDataSource();

    try {

      URI dbUri = new URI(System.getenv("DATABASE_URL"));

      String username = dbUri.getUserInfo().split(":")[0];
      String password = dbUri.getUserInfo().split(":")[1];

      String dbUrl =
          "jdbc:postgresql://"
              + dbUri.getHost()
              + ':'
              + dbUri.getPort()
              + dbUri.getPath()
              + "?sslmode=require";

      basicDataSource.setUrl(dbUrl);
      basicDataSource.setUsername(username);
      basicDataSource.setPassword(password);

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return basicDataSource;
  }
}
