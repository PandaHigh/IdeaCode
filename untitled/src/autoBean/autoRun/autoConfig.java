package autoBean.autoRun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "autoBean.autoRun")
public class autoConfig {
    @Bean(name="singerOne")
    public Singer singer1(){
        return new SingerOne();
    }
    @Bean(name="singerSayHello")
    public SingerSay singerSay(){
        SingerSay singerSay1=new SingerSay();
        singerSay1.setSinger(singer1());
        return singerSay1;
    }
    @Bean(name="audience")
    public Audience audience(){
        return new Audience();
    }

}
