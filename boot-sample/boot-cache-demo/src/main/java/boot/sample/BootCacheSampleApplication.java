package boot.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/21
 */
@SpringBootApplication
//@EnableCaching
@MapperScan("boot.sample.mapper")
public class BootCacheSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCacheSampleApplication.class,args);
    }
}
