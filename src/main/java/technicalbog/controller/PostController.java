package technicalbog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import technicalbog.model.Post;
import technicalbog.service.PostService;

import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPost(Model model) {
        ArrayList<Post> posts = postService.getonepost();

        model.addAttribute("posts",posts);

        return "posts";
    }

    @RequestMapping(value = "posts/create",method = RequestMethod.POST)
    public String createPost(Post newPost){
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping("posts/newpost")
    public String newpost() {
        return "posts/create";
    }
}
