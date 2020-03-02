package docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linjinbao66@gmail.com
 * @date 2020/3/2
 */
@SpringBootApplication
@RestController
public class DockerApplication {
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }
}
