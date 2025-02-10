package my.app.first_Project.controller;

import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @GetMapping({"/main", "", "/"})
    public String main() {

        return "articles/main";
    }

    @GetMapping("/list")
    public String list() {

        return "articles/article/list_all";
    }

    @GetMapping("/{id}")
    public String selectList(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "articles/article/list_one";
    }

    // /articles/create(name=${tom},weight=${80},height=${180})
    @GetMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("weight") int weight, @RequestParam("height") int height, Model model) {
        UserData userData = new UserData();
        userData.setUserName(name);
        userData.setUserHeight(height);
        userData.setUserWeight(weight);
        model.addAttribute("data", userData);
        return "articles/article/new";
    }

    @GetMapping("/update")
    public String update_ok() {

        return "articles/article/update_ok";
    }

    // @PostMapping("/update") Get으로 받은걸 post로도 받을수 있음 대신 메서드 이름은 바꿔야함
// public String updateok(){ <<<----- 요거 바꿔
//
//  return "articles/article/update_ok"; 이건 같은걸 써도 됨
// }
// /articles/{id}(id=7)/update
    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "articles/article/update";
    }

    // /articles/{id}/delete(id=${3})
    @GetMapping("/{id}/delete")
    public String delete_ok(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "articles/article/delete_ok";
    }
// {id}/articleComment(id=${11})
// @GetMapping("/{id}/articleComment")
// public String Comment(@PathVariable("id")String id ,Model model){
//  model.addAttribute("id", id);
//  return "articles/article/comment_view";
// }
// @GetMapping("/{id}/articleComments/{articlecomment-id}/delete")
// public String delete(@PathVariable("id")String id,@PathVariable("articlecomment-id")String aid ,Model model){
//  model.addAttribute("id", id);
//  model.addAttribute("aid", aid);
//  return "articles/article/delete_comment";
// }

}
