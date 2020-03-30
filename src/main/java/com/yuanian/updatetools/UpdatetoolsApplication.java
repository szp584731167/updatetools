package com.yuanian.updatetools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**spring boot会默认加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration类
因为新建的spring boot 工程中没有dataSource相关的配置信息，所以一启动就报错
 添加(exclude={DataSourceAutoConfiguration.class})
或者配置datasource信息，补全配置文件即可
*/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class UpdatetoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdatetoolsApplication.class, args);
    }

}
