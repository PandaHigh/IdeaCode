package inAction;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnquest(){
//        Quest mockQuest=mock(myQuest.class);
//        BraveKnight braveKnight = new BraveKnight(mockQuest);
//        braveKnight.embarkOnQuest();
//        verify(mockQuest,times(1)).embark();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Knight braveKnight = context.getBean(Knight.class);
        braveKnight.embarkOnQuest();
        context.close();
    }
}
