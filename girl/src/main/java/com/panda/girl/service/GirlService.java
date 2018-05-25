package com.panda.girl.service;

import com.panda.girl.domain.Girl;
import com.panda.girl.enums.ResultEnum;
import com.panda.girl.exception.GirlException;
import com.panda.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    public GirlRepository girlRepository;

    /**
     * Transactional是事务管理的注解，要么整个事件完成，要么整个事件失败
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(30);
        girlA.setCupSize("A");
        Girl girlB=new Girl();
        girlB.setAge(49);
        girlB.setCupSize("C");
        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }
    public Girl getAge(Integer id)throws Exception{
        Optional<Girl>  girlById= girlRepository.findById(id);
        Girl girl=girlById.get();
        Integer age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age<18){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else{
            return girl;
        }
    }
}
