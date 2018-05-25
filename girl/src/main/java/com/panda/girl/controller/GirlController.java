package com.panda.girl.controller;

import com.panda.girl.domain.Result;
import com.panda.girl.repository.GirlRepository;
import com.panda.girl.service.GirlService;
import com.panda.girl.domain.Girl;
import com.panda.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private static final Logger logger=LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    public GirlService girlService;
    /**
     * 返回表girl中的所有数据
     * @return
     */
    @GetMapping(value="/girl")
    public List<Girl> girlList(){
        logger.info("method of girlList() is running!");
        return girlRepository.findAll();
    }

    /**
     * 往girl表中添加一条数据
     * @return`
     */
    @PostMapping(value="/girl")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtils.error(bindingResult.getFieldError().getDefaultMessage(),1);
        }
        girlRepository.save(girl);
        return ResultUtils.success(girl);
    }

    /**
     * 返回指定id的一条数据
     * @param id
     * @return
     */
    @GetMapping(value="/girl/{id}")
    public Result girlGet(@PathVariable("id") Integer id) throws Exception {
//        Optional<Girl> girl= girlRepository.findById(id);
//        return girl.get();
        return ResultUtils.success(girlService.getAge(id));
    }

    /**
     * 更新指定数据
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value="/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return girl;
    }

    /**
     * 删除指定的一条数据
     * @param id
     */
    @DeleteMapping(value="/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value="/girl/insert")
    public void girlInsertTwo(){
        girlService.insertTwo();
    }
}
