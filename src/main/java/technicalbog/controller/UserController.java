package technicalbog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalbog.model.Post;
import technicalbog.model.User;
import technicalbog.model.UserProfile;
import technicalbog.service.PostService;
import technicalbog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(Model model) {
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User",user);
        return "users/registration";
    }
    @RequestMapping(value = "users/registration",method = RequestMethod.POST)
    public String reisterUser(User user) {
        userService.registerUser(user);
        return "users/login";
    }

    @RequestMapping(value = "users/login",method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session) {

        User existingUser = userService.login(user);
        if(existingUser != null) {
            session.setAttribute("loggeduser",existingUser);
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout",method = RequestMethod.POST)
    public String logoutuser(Model model,HttpSession session) throws ClassNotFoundException {
        session.invalidate();
        List<Post> posts=postService.getAllPosts();


        model.addAttribute("posts",posts);
        return "index";
    }
}
