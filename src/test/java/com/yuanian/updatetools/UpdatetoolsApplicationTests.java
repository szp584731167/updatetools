package com.yuanian.updatetools;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootTest(classes = UpdatetoolsApplication.class)
@RunWith(SpringRunner.class)
class UpdatetoolsApplicationTests {



    @Test
    void contextLoads() {

    }

}
