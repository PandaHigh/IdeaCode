package com.panda.girl;

import com.panda.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService girlService;
    @Test
    public void getAge()throws Exception{
        Assert.assertEquals(new Integer(30),girlService.getAge(5).getAge());
    }
}
