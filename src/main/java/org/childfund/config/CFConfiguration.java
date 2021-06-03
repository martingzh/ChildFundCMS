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
    URI dbUri =
        new URI(
            "postgres://twvcxtnjmotzym:d62b0f301908da0f8f4797643a35403b63d9d42d6820a8aaec7c7c57ba9f3cc2@ec2-54-211-176-156.compute-1.amazonaws.com:5432/d63otge472kq68");

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl =
        "jdbc:postgresql://"
            + dbUri.getHost()
            + ':'
            + dbUri.getPort()
            + dbUri.getPath()
            + "?sslmode=require";

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl(dbUrl);
    basicDataSource.setUsername(username);
    basicDataSource.setPassword(password);

    return basicDataSource;
  }
}
