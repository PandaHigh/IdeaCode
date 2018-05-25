package com.panda.girl.controller;

import com.panda.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/girl")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value={"/hello","/hi"},method=RequestMethod.GET)
    public String say(@RequestParam(value="id",required=false,defaultValue = "0") int id){
        return ""+id;
    }
}
