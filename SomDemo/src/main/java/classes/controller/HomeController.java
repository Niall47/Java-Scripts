package classes.controller;

import classes.Main;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class HomeController{
//    @RequestMapping("/")
//    public int home(){
//        return Main.vehicle_registry.size();
//
//    }
//}
@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/java")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}