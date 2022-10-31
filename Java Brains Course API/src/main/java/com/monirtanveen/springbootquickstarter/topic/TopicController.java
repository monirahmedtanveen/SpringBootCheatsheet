package com.monirtanveen.springbootquickstarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
                new Topic("spring", "Spring Framwork", "Spring Framework Description"),
                new Topic("java", "Core Java", "Core java Description"),
                new Topic("javascript", "Javascript", "Javascript Description")
        );
    }
}
