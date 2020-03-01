package elk;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElkApplicationTests {

    @Test
    public void contextLoads() {
    }

    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void test() throws Exception {

        for(int i=0;i<100;i++) {
            logger.info("输出info  ");
            logger.debug("输出debug+skkkw嗡嗡嗡kw");
            logger.error("输出error  嗡嗡嗡我");
        }
    }


}
