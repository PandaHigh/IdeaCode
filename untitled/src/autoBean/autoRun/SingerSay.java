package autoBean.autoRun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


public class SingerSay {


    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    private Singer singer;

    public void say(){
        singer.say(10);
    }
//    @Autowired
//    @Qualifier("singer5")
//    private Singer singer2;
//    public void say2(){
//        singer2.say();
//    }
}
