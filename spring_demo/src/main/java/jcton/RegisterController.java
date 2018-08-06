package jcton;

import jcton.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jcton.service.IUserService;

import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView acquireForForm(){
        User user = new User();

        ModelAndView mv = new ModelAndView("register");
        mv.addObject("registerForm", user);
        return mv;
    }

    @PostMapping
    public ModelAndView registerSubmit(@ModelAttribute("registerForm") User u, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView("newuser");
        mv.addObject("name", u.getName());
        System.out.println(u.getName());

        userService.register(u);


        return mv;
    }



}
