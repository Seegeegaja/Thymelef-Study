package my.app.first_Project.controller;

import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class ThymeleafContorller {
//    http://localhost:8080/basic/text-basic
    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("name", "안유진");
        model.addAttribute("See", "mylove");
        return "/basic/text-basic";
    }
    @GetMapping("/Variables")
    public String variables(Model model){
        UserData userData = new UserData("홍길동", 10);
        System.out.println(userData);
        model.addAttribute("usetData", userData);
        model.addAttribute("data", "장원영");
        return "/basic/variables";
    }

}
