package mybatis.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@MapperScan("mybatis.simple.mapper")
@SpringBootApplication
public class MybatisBootstrap {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream in= MybatisBootstrap.class.getClassLoader().getResourceAsStream("application-simple.properties");
        properties.load(in);
        SpringApplication springApplication=new SpringApplication(MybatisBootstrap.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
