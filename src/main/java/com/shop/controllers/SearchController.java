package com.shop.controllers;


import com.shop.database.DB;
import com.shop.enums.PostCategory;
import com.shop.models.Post;
import com.shop.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class SearchController {

    //TODO: css,add error logs, add refs to subSectors ,csssssssssssssssssssssssssss

    private final SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/category")
    public ModelAndView getLargeSectorPosts(@RequestParam("Category") String category) {
        System.out.println(category);
        ArrayList<Post> posts = DB.getPostsByLargeCategory(category);
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("posts", posts);
        modelAndView.addObject("category", category);
        modelAndView.addObject("subSectors", PostCategory.getSubSectors(category));
        return modelAndView;
    }

    @GetMapping("/subCategory")
    public ModelAndView getSubCategory(@RequestParam("subcategory") String subSector) {
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("category", subSector);
        modelAndView.addObject("posts", service.getPostsBySubSector(subSector));
        modelAndView.addObject("superCategory", PostCategory.getSuperCategory(subSector));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView getSearchResponse(@RequestParam("searchContent") String searchContent) {
        if (searchContent == "") {
            return new ModelAndView("redirect:home");
        }
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("posts", service.getSearchResult(searchContent));
        return modelAndView;
    }
}
