package inAction;

import java.io.PrintStream;

public class Minstrel {
    private PrintStream stream;
    public Minstrel(PrintStream stream){
        this.stream=stream;
    }
    public void singBeforeQuest(){
        stream.println("全军出击");
    }
    public void singAfterQuest(){
        stream.println("恭喜骑士胜利归来！");
    }
}
