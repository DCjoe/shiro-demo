package com.fnl.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping({"/","/index"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/{filePath}")
    public String page(@PathVariable String filePath){
        return "admin/"+filePath;
    }

    @GetMapping("/tables")
    @RequiresPermissions("tables")
    public String buttonsPage(){
        return "admin/tables";
    }

    @GetMapping("/403")
    public String unauthorizedUrl(){
        return "error/403";
    }
}
