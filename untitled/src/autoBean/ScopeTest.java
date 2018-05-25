package autoBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//public class ScopeTest implements InitializingBean,DisposableBean,ApplicationContextAware,BeanNameAware {
//    public void play(){
//        System.out.println("Scope test:"+this.hashCode());
//    }
//
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("执行初始化");
//    }
//
//    public void destroy() throws Exception {
//        System.out.println("执行销毁");
//    }
//    String beanName;
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("application Bean"+applicationContext.getBean(beanName).hashCode());
//    }
//
//    public void setBeanName(String s) {
//        this.beanName=s;
//        System.out.println("Bean name:"+s);
//    }
//}
