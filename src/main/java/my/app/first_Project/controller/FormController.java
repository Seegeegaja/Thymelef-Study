package my.app.first_Project.controller;

import my.app.first_Project.dto.Country;
import my.app.first_Project.dto.Language;
import my.app.first_Project.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    @GetMapping({"/userform", "/userForm"})
    public String showForm(Model model) {
        //처음 시작 할때 바인딩 되어있는 UserInfoDto의 껍데기를 보내면 됨
//        Map<String, String> map = favorite();
//        model.addAttribute("map", map);
        model.addAttribute("user", new UserInfo());
//        model.addAttribute("hobbies", favorite()); 이것이 생략이 됬고 이유는 UserInfo dto에 있는거라

        return "form/basicForm";
    }

    @ModelAttribute("nation")
    private Country[] countries() {
        return Country.values();
    }

    @ModelAttribute("lang")
    private Language[] languages() {
        return Language.values();
    }

    @ModelAttribute("hobbies")
    private Map<String, String> favorite() {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("running", "런닝하기");
        map.put("game", "게임하기");
        return map;
    }

    @GetMapping("/sendData")
    public String sendData(UserInfo userInfo, Model model) {
        model.addAttribute("nickname", userInfo.getNickname());
        model.addAttribute("email", userInfo.getEmail());
        System.out.println(userInfo);
        return "form/return";
    }

    //    @PostMapping("/sendData")
//    public String sendPostData(
//    @RequestParam("nickname")String nickname ,
//    @RequestParam("email")String email,
//    Model model){
//        model.addAttribute("nickname", nickname);
//        model.addAttribute("email", email);
//        return "/form/return";
//    }
    @PostMapping("/sendData")
    public String sendPostData(
            @ModelAttribute("user") UserInfo info,
            Model model) {
        System.out.println(info);
        model.addAttribute("info", info);

        return "form/return";
    }

    @GetMapping("viewData")
    public String viewData(Model model) {
        UserInfo user = new UserInfo();
        user.setNickname("카리나");
        user.setEmail("rina@naver.com");
        model.addAttribute("user", user);
        return "form/basicForm";
    }
}
