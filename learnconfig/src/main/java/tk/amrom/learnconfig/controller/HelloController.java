package tk.amrom.learnconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.amrom.learnconfig.bean.ConfigBean;

@RestController
public class HelloController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @Value("${my.number}")
    private int number;
    @RequestMapping(value = "/hi")
    public String hi(){
        return name+ ":" + age + ":" + number;
    }
    @Autowired
    private ConfigBean configBean;
    @RequestMapping("/hello")
    public String hello(){
        return configBean.toString();
    }
}
