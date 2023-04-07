package controller;

import chapter10.DuplicationMemberException;
import chapter10.MemberRegisterService;
import chapter10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

  @RequestMapping("/step1")
  public String handleStep1() {
    System.out.println("step1 >>>");
    return "register/step1";
  }

//  @PostMapping("/step2")
//  public String handleStep2(HttpServletRequest reqeust) {
//    System.out.println("step2 >>>");
//    String agree = reqeust.getParameter("agree");
//    System.out.println("step2::agree"+ agree);
//    if(agree == null || !agree.equals("true")) {
//      return "register/step1";
//    }
//    return "register/step2";
//  }

  @PostMapping("/step2")
  public String handleStep2(@RequestParam(value="agree", defaultValue = "false") Boolean agree
      , Model model) {
    System.out.println("[POST] step2 >>>");
    System.out.println("step2::agree = "+ agree);
    if(!agree) {
      return "register/step1";
    }
    model.addAttribute("formData",new RegisterRequest());
    return "register/step2";
  }

  @Autowired
  private MemberRegisterService memberRegisterService;

//  @PostMapping("/step3")
//  public String handleStep3(HttpServletRequest request) {
//    String email = request.getParameter("email");
//    String name = request.getParameter("name");
//    String password = request.getParameter("password");
//    String confirmPassword = request.getParameter("confirmPassword");
//
//    RegisterRequest req = new RegisterRequest();
//    req.setEmail(email);
//    req.setName(name);
//    req.setPassword(password);
//    req.setConfirmPassword(confirmPassword);
//
//    try {
//      memberRegisterService.regist(req);
//      return "register/step3";
//    } catch (DuplicationMemberException ex) {
//      return "register/step2";
//    }
//  }
  @PostMapping("/step3")
  public String handleStep3(@ModelAttribute("formData") RegisterRequest registerRequest) {
    System.out.println("[POST] step3 >>>");
    try {
      memberRegisterService.regist(registerRequest);
      return "register/step3";
    } catch (DuplicationMemberException ex) {
      return "register/step2";
    }
  }




}