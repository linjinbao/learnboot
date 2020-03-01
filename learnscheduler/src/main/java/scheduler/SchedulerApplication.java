package scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author linjinbao66@gmail.com
 * date 2020-03-01
 * @apiVersion
 * @apiGroup
 * @apiDescription
 * @apiParam
 * @apiParamExample
 * @apiSuccess (200)
 * @apiSuccessExample
 */
@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }

}
