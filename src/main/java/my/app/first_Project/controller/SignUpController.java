package my.app.first_Project.controller;

import my.app.first_Project.dto.Mailing;
import my.app.first_Project.dto.Promise;
import my.app.first_Project.dto.Sex;
import my.app.first_Project.dto.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("signup")
public class SignUpController {
    @GetMapping("main")
    public String signup(Model model){
        model.addAttribute("signup", new SignUp());
        return "signup/main";
    }
    @ModelAttribute("maleOrFemale")
    private Sex[] sexes(){
        return Sex.values();
    }
    @ModelAttribute("emailing")
    private Mailing[] mailings(){
        return Mailing.values();
    }
    @ModelAttribute("promi")
    private Map<String,String>selectP(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("이용동의", "이용약관에 동의 합니다");
        map.put("개인정보(필수)", "개인정보 수집-이용 동의(필수)");
        map.put("개인정보(선택)", "개인정보 수집-이용 동의(선택)");

        return map;
    }
    @GetMapping("data")
    public String data(Model model){

        return "signup/return";
    }

}

