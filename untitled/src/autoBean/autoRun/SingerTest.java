package autoBean.autoRun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = autoConfig.class)
public class SingerTest {
    @Test
    public void testSay(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(autoConfig.class);
        context.refresh();
        Singer singer =(Singer) context.getBean("singerOne");
        singer.say(20);
    }
}
