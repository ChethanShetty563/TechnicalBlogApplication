package technicalbog.service;

import org.springframework.stereotype.Service;
import technicalbog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    public PostService() {
        System.out.println("***Post Service***");
    }

    public ArrayList<Post> getAllPosts() {

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

        return posts;
    }
    public ArrayList<Post> getonepost() {
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("This is your Post 1");
        post.setBody("This is your Post body1");
        post.setDate(new Date());

        posts.add(post);

        return posts;

    }
    public void createPost (Post newPost){
    }
}
