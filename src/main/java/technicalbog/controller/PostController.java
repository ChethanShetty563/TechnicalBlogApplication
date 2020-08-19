package technicalbog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import technicalbog.model.Category;
import technicalbog.model.Post;
import technicalbog.model.User;
import technicalbog.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPost(Model model) {
//        ArrayList<Post> posts  = new ArrayList<>();
        List<Post> posts = postService.getAllPosts();
//       posts.add(latestPosts);
        model.addAttribute("posts",posts);

        return "posts";
    }

    @RequestMapping(value = "posts/create",method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session){
       User user =  (User)session.getAttribute("loggeduser");
        newPost.setDate(new Date());
        newPost.setUser(user);
//        if (newPost.getSpringBlog() != null) {
//            Category springBlogCategory = new Category();
//            springBlogCategory.setCategory(newPost.getSpringBlog());
//            newPost.getCategoryList().add(springBlogCategory);
//        }
//
//        if (newPost.getJavaBlog() != null) {
//            Category javaBlogCategory = new Category();
//            javaBlogCategory.setCategory(newPost.getJavaBlog());
//            newPost.getCategoryList().add(javaBlogCategory);
//        }
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value="/editpost", method=RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId,Model model) {
        Post post =  postService.getPost(postId);
        model.addAttribute("post",post);

        return "posts/edit";

    }
    @RequestMapping(value="/editPost", method=RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId,Post updatedPost,HttpSession session) {

        updatedPost.setId(postId);
        User user = (User)session.getAttribute("loggeduser");
        updatedPost.setUser(user);
        postService.updatePost(updatedPost);
        return "redirect:/posts";

    }

    @RequestMapping(value = "/deletepost", method=RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId ) {
        postService.deletePost(postId);
        return "redirect:/posts";

    }



    @RequestMapping("posts/newpost")
    public String newpost() {
        return "posts/create";
    }
}
