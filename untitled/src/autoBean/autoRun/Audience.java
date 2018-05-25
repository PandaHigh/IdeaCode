package autoBean.autoRun;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
@Aspect
public class Audience {
    @Pointcut("execution(* autoBean.autoRun.SingerOne.say(int))&&args(a)")
    public void saySomething(int a){}
//    @Before("saySomething()")
//    public void singBefore(){
//        System.out.println("lalalalalala!!!!");
//    }
//    @After("saySomething()")
//    public void singAfter(){
//        System.out.println("bullshit!!!!");
//    }
    @Around("saySomething(a)")
    public void singAround(ProceedingJoinPoint processingJoinPoint,int a){
        try{
            System.out.println(a);
            System.out.println("hello");
            processingJoinPoint.proceed();
            System.out.println("bye");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
