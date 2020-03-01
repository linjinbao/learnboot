package learnswagger2.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value="hello", notes="hell")
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

}
