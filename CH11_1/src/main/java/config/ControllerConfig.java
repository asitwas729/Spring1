package config;

import chapter11.AuthService;
import controller.HelloController;
import controller.LoginController;
import controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import survey.SurveyController;

@Configuration
public class ControllerConfig {

  @Autowired
  private AuthService authService;

  @Bean
  public RegisterController registerController() {
    return new RegisterController();
  }

  @Bean
  public HelloController helloController() {
    return new HelloController();
  }

  @Bean
  public SurveyController surveyController() {
    return new SurveyController();
  }

  @Bean
  public LoginController loginController() {
    LoginController loginController= new LoginController();
    loginController.setAuthService(authService);
    return loginController;
  }
}