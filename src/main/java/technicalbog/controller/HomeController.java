package technicalbog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalbog.model.Post;
import technicalbog.service.PostService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    public HomeController() {
        System.out.println("***HomeController***");
    }

    @RequestMapping("/")
    public String getAllPost(Model model) throws ClassNotFoundException {

        List<Post> posts=postService.getAllPosts();

        model.addAttribute("posts",posts);

        return "index";

    }
}
