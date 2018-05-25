package autoBean;

import autoBean.CompactDisc;
import autoBean.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;
    public CDPlayer(CompactDisc cd){
        this.cd=cd;
    }
    public void play() {
        cd.play();
    }
}
