package autoBean;

import autoBean.config.CDPlayerConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayTest {
//    @Autowired
//    private CompactDisc cd;
//    @Autowired
//    private MediaPlayer player;
//    @Test
//    public void cdShouldNotBeNull(){
//        assertNotNull(cd);
//    }
    @Test
    public void play() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CDPlayerConfig.class);
        context.refresh();
        context.getBean("mediaPlayer",MediaPlayer.class).play();
    }

}
