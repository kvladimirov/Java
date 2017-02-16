package app.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot";
    }
    @RequestMapping("/date")
    public String date() { return new Date().toString(); }
    @RequestMapping("/Kosyo/new/hello")
    public int[] kosyo() {
        return new int[] {05, 11, 1985};
    }

}
