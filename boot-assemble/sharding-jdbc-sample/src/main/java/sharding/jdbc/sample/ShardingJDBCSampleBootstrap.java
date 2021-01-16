package sharding.jdbc.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/30
 */
@SpringBootApplication
@MapperScan("sharding.jdbc.sample.mapper")
public class ShardingJDBCSampleBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCSampleBootstrap.class,args);
    }
}
