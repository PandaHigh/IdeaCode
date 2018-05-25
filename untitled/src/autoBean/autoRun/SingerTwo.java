package autoBean.autoRun;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component("singer5")
public class SingerTwo implements Singer {
    public void say(int a) {
        System.out.println("SingerTwo");
    }
}
