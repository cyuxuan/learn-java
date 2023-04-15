package cn.cyuxuan.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.cyuxuan")
@MapperScan("cn.cyuxuan.dao")
public class SpringWebTestFieldApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebTestFieldApplication.class);
    }
}
