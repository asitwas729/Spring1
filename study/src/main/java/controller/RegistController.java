package controller;

import chapter10.DuplicationMemberException;
import chapter10.MemberRegisterService;
import chapter10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

//    @PostMapping("/step2")
//    public String handleStep2(HttpServletRequest request) {
//        String agree = request.getParameter("agree");
//        System.out.println("agree : "+ agree);
//        if(agree == null || !agree.equals("true")) {
//            return "register/step1";
//        }
//        return "register/step2";
//    }

    @GetMapping("/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value="agree", required = false) Boolean agree
            , Model model) {
        System.out.println("[POST] step2 >>>");
        System.out.println("step2::agree = "+ agree);
        if(!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest",new RegisterRequest());
        return "register/step2";
    }

    @PostMapping("/step3")
    public String handleStep3(@Valid RegisterRequest req, Errors errors) {

        // new RegisterRequestValidator().validate(req, errors);
        if(errors.hasErrors()) {
            return "register/step2";
        }
        try {
            memberRegisterService.regist(req);
            return "register/step3";
        } catch (DuplicationMemberException ex) {
            errors.rejectValue("email", "duplicate");
            return "register/step2";
        }

    }



}
