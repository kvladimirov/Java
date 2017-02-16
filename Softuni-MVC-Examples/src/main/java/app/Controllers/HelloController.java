package app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello-view")
    public String hello(Model model) {
        model.addAttribute("msg",
                "Hello Spring MVC + Thymeleaf");
        model.addAttribute("date",
                new Date().toString());
        return "hello-view";
    }

    @RequestMapping("/numbers")
    public String numbers() {
        return "numbers";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}



