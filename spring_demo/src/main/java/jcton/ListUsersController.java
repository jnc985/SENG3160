package jcton;

import jcton.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jcton.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("/list")
public class ListUsersController {

    @Autowired
    IUserService userService;

    @GetMapping()
    public ModelAndView listUsers(){
        ModelAndView mv = new ModelAndView("listusers");

        List<User> users = userService.getAll();
        mv.addObject("userlist", users);
        return mv;
    }

}
