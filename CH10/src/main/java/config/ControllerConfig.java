package config;

import controller.HelloController;
import controller.MainController;
import controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class ControllerConfig {

  @Bean
  public RegisterController registerController() {
    return new RegisterController();
  }

  @Bean
  public HelloController helloController() {
    return new HelloController();
  }


}