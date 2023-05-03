package config;

import chapter11.AuthService;
import controller.HelloController;
import controller.LoginController;
import controller.RegistController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private AuthService authService;

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegistController registController() {
        return new RegistController();
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }
}
