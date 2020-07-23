package mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("mybatis.mapper")
@SpringBootApplication
public class MybatisBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(MybatisBootstrap.class,args);
    }
}
