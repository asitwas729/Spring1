package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

  @GetMapping("/survey")
  public String Form(SurveyCommand surveyCommand){
    return "survey/surveyFrom";
  }
}
