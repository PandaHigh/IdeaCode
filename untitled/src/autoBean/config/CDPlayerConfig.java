package autoBean.config;

import autoBean.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "autoBean")
public class CDPlayerConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
    @Bean
    public MediaPlayer mediaPlayer(){
        return new CDPlayer(compactDisc());
    }
}
