package com.lrm.web;

import com.lrm.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        System.out.println("-----------index-----------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        System.out.println("-----------blog-----------");
        return "blog";
    }

    @GetMapping("/index")
    public String login(){
        return "admin/index";
    }
}
