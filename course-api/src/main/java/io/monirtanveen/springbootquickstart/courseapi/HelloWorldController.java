package io.monirtanveen.springbootquickstart.courseapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, value = "/hello-world")
    public String sayHello() {
        return "Hello World SpringBoot World";
    }
}
