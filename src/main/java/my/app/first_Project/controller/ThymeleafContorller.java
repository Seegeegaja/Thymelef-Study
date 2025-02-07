package my.app.first_Project.controller;

import my.app.first_Project.dto.Animal;
import my.app.first_Project.dto.Fruits;
import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/basic")
public class ThymeleafContorller {
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("nowDateTime", LocalDateTime.now());
        return "/utility/date";
    }


//    http://localhost:8080/basic/text-basic
    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("name", "안유진");
        model.addAttribute("See", "mylove");
        return "/basic/text-basic";
    }
    @GetMapping("/variables")
    public String variables(Model model){
        UserData userData = new UserData();
        userData.setUserName("안유진");
        userData.setUserAge(20);
        userData.setUserAddress("서울");
        System.out.println(userData);
        model.addAttribute("userData", userData);
        model.addAttribute("data", "장원영");


        //리스트 만들기
        List<Fruits> fruits = new ArrayList<>();
        Fruits apple = new Fruits("사과", "신맛");
        Fruits mango = new Fruits("망고", "노란맛");

        fruits.add(apple);
        fruits.add(mango);
        model.addAttribute("fruits",fruits);
        System.out.println(fruits);
        //맵으로 작업
        Map<String, Animal> animalMap = new HashMap<>();
        Animal dog = new Animal();
        dog.setName("망망이");
        dog.setSound("망망");

        Animal cat = new Animal();
        cat.setName("나비");
        cat.setSound("야옹");

        animalMap.put("dog",dog);
        animalMap.put("cat",cat);
        model.addAttribute("map",animalMap);
        return "basic/variables";

    }
    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data", "spring");
        return "/basic/literal";
    }
    @GetMapping("/operation")
    public String operation(Model model){
        model.addAttribute("a", 10);
        model.addAttribute("b", 3);
        model.addAttribute("nullData", null);
        model.addAttribute("name", "안유진");
        return "/basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute(Model model) {

        return "basic/attribute";
    }
    @GetMapping("/for")
    public String forOperation(Model model){
        addUser(model);
        return "/basic/for_opr";
    }

    private void addUser(Model model) {
        List<UserData> userList = new ArrayList<>(
                Arrays.asList(
                        new UserData("카리나",21,"서울" , 45 , 175),
                        new UserData("윈터",22,"부산" , 45 , 160),
                        new UserData("닝닝",25,"대구" , 50 , 165),
                        new UserData("리사",30,"태국" , 51 , 170),
                        new UserData("몰랑",35,"중국" , 80 , 185)
                )
        );
        model.addAttribute("userList", userList);
        System.out.println(userList);

    }
    @GetMapping("/myselceter")
    public String detail(
            @RequestParam("name")String name,
            @RequestParam("age")int age,
            @RequestParam("address")String address,
            @RequestParam("weight")int weight,
            @RequestParam("height")int height,
            Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("address", address);
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        return "basic/detail";
    }
    @GetMapping("/add")
    public String add(@RequestParam("name")String name,
                      @RequestParam("age")int age,
                      @RequestParam("address")String address,
                      @RequestParam("weight")int weight,
                      @RequestParam("height")int height,Model model){
        model.addAttribute("selectUser", UserData.fromParams(name,age,address,weight,height));
        return "basic/detailToo";
    }

}
