package autoBean;

import org.springframework.stereotype.Component;

public class SgtPeppers implements CompactDisc {
    private String title="天空之城";
    private String artist="李志";
    public void play() {
        System.out.println("Playing:"+title+"by"+artist);
    }
}
