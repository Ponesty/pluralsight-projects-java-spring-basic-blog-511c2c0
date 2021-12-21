package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    private PostRepository postRepository;

    @RequestMapping("/")
    public String listPosts(ModelMap mMap){
        List<Post> repo = postRepository.getAllPosts();
        mMap.put("posts",repo);
        return "home";
    }



    public BlogController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        Post postVar = postRepository.findById(id);
        modelMap.put("post",postVar);
        return "post-details";

    }

}
