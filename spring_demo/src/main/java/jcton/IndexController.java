package jcton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "Guest") String name){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", name);
        return mv;
    }
}
