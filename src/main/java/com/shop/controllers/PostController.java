package com.shop.controllers;

import com.shop.database.DB;
import com.shop.models.Post;
import com.shop.models.User;
import com.shop.service.AddPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes({"user"})
public class PostController {

    private final AddPostService addPostService;

    @Autowired
    public PostController(AddPostService addPostService) {
        this.addPostService = addPostService;
    }

    @RequestMapping(value = "/addPost")
    public ModelAndView getAddPostPage() {
        return new ModelAndView("PostPackage/chooseCategory");
    }


    @RequestMapping(value = "/addPost/")
    public ModelAndView fillTheBlank(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("PostPackage/addPost");
        modelAndView.addObject("category",
                addPostService.getCategory(params));
        return modelAndView;
    }

    @RequestMapping(value = "/addPost/create")
    public RedirectView create(@RequestParam Map<String, String> params,
                               HttpSession session) {
        Post post = addPostService.createPost(params);
        User user = (User) session.getAttribute("user");
        post.setAuthorId(user.getUserId());
        DB.posts.add(post);
        user.getPosts().add(post);
        return new RedirectView("/userprofile");
    }


    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public RedirectView deletePost(@RequestParam("postId") String postId, @SessionAttribute("user") User user) {
        Post post = DB.getPostById(Integer.valueOf(postId));
        user.getPosts().remove(post);
        DB.posts.remove(post);
        return new RedirectView("/userprofile");
    }


    @RequestMapping(value = "/modifyPost", method = RequestMethod.POST)
    public ModelAndView modifyPost(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("PostPackage/modify");
        String postId = params.get("postId");
        Post post = DB.getPostById(Integer.valueOf(postId));
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @RequestMapping(value = "/modifyPost")
    public RedirectView modify(@RequestParam Map<String, String> params) {
        Post post = DB.getPostById(Integer.valueOf(params.get("postId")));
        String title = params.get("title");
        String comment = params.get("comment");
        post.setTitle(title);
        post.setComment(comment);
        return new RedirectView("/userprofile");
    }

    @GetMapping("/post")
    public ModelAndView getPostPage(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("PostPackage/post");
        modelAndView.addObject("post", DB.getPostById(Integer.valueOf(params.get("postId"))));
        modelAndView.addObject("author", DB.getUserById(Integer.valueOf(params.get("authorId"))));
        return modelAndView;
    }

    @GetMapping("/posts")
    public ModelAndView getPostsByUser(@RequestParam Map<String, String> params, HttpSession session) {
        int userId = Integer.parseInt(params.get("userId"));
        User user = (User) session.getAttribute("user");
        Integer sessionUserId = user.getUserId();
        if (userId == sessionUserId) {
            return new ModelAndView("redirect:userprofile");
        } else {
            User user1 = DB.getUserById(userId);
            ModelAndView modelAndView = new ModelAndView("PostPackage/allUserPosts");
            modelAndView.addObject("author", user1);
            return modelAndView;
        }
    }

    @PostMapping("/unSavePost")
    public RedirectView unSavePost(@RequestParam Map<String, String> params, HttpSession session,
                                   RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        user.getFavoritePosts().remove(DB.getPostById(Integer.valueOf(params.get("postId"))));
        redirectAttributes.addAllAttributes(params);
        return new RedirectView("/post");
    }


    @PostMapping("savePost")
    public RedirectView savePost(@RequestParam Map<String, String> params, HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        user.getFavoritePosts().add(DB.getPostById(Integer.valueOf(params.get("postId"))));
        redirectAttributes.addAllAttributes(params);
        return new RedirectView("/post");
    }


    @PostMapping("saveUser")
    public RedirectView saveUser(@RequestParam Map<String, String> params, HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        user.getFavoriteUsers().add(DB.getUserById(Integer.valueOf(params.get("userId"))));
        redirectAttributes.addAllAttributes(params);
        return new RedirectView("/posts");
    }

    @PostMapping("unSaveUser")
    public RedirectView unSaveUser(@RequestParam Map<String, String> params, HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        user.getFavoriteUsers().remove(DB.getUserById(Integer.valueOf(params.get("userId"))));
        redirectAttributes.addAllAttributes(params);
        return new RedirectView("/posts");
    }

}
