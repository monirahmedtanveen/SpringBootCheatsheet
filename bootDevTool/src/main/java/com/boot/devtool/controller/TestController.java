package com.boot.devtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        int a = 10;
        int b = 20;
        int c = 18;

        return "Addition is : " + (a + b + c);
    }
}
