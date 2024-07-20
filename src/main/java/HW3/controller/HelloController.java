package HW3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping( "/hello")
    public String helloPage(@RequestParam(required = false) String username) {
        return " <h1>Hello, " + username +  "!</h1>";
    }
    @GetMapping( "/hello/{username}")
    public String helloPagePathVariable(@PathVariable String username) {
        return " <h1>Hello, " + username +  "!</h1>";
    }

}
