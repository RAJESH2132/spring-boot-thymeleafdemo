package com.springboot.com.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    //controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String formVersionTwo(HttpServletRequest request, Model model){
        //read req parameter from html form
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create message
        String result = "Yo!" + theName;

        //add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String formVersionThree(@RequestParam("studentName") String theName,Model model){

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create message
        String result = "Hello v3! " + theName;

        //add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
