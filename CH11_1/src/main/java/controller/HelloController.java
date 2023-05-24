package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

  // 이전버전 : @RequestMapping(value = "/hello", method = RequestMethod.GET)
  @GetMapping("/hello")
  public String hello(Model model, @RequestParam(value="name", required = false) String name) {
    model.addAttribute("greeting", "안녕하세요" + name);
    return "hello";
  }



}