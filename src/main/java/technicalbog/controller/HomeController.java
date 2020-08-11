package technicalbog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalbog.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getAllPost(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Post 1");
        post.setBody("Post body1");
        post.setDate(new Date());

        Post post1 = new Post();
        post1.setTitle("Post 2");
        post1.setBody("Post body2");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 3");
        post2.setBody("Post body3");
        post2.setDate(new Date());
        posts.add(post);
        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts",posts);

        return "index";

    }
}
