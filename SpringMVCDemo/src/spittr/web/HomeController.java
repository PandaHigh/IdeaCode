package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {
    //处理对“/”的GET请求
    @RequestMapping(value="/",method=GET)
    public String home(){
        return "home";//视图名为home
    }
}
