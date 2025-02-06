package my.app.first_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//외부에서 요청하는 url을 처리하는 아이
//요청할 대상은  localhost:8081/mypage --> 요청받을 아이를 만들 곳
@RequestMapping("/main")
public class MyController {
    @GetMapping({"/mypage","/myPage"})
    public String getMypage() {
        return "myOldPage";
    }
    @GetMapping("about")
    public String about(){
        return "about";
    }

}
