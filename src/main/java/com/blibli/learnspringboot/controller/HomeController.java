package com.blibli.learnspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "")
public class HomeController {

    /**
     * GET localhost:8080/
     * @return
     */
    @GetMapping(path = "/home")
    public @ResponseBody String index () {
        return "Welcome to a New Java Web Application";
    }

    /**
     * GET localhost:8080/home
     */
    @GetMapping(path = "/home/getAllUsers")
    public @ResponseBody List<String> getAllUsers () {
        List<String> users = new ArrayList<String>();
        users.add("Goldwin");
        users.add("Luciana");
        users.add("Misita");
        return users;
    }
}
