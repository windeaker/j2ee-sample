package security1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class Security1Boot {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream in= Security1Boot.class.getClassLoader().getResourceAsStream("application-1.properties");
        properties.load(in);
        SpringApplication springApplication=new SpringApplication(Security1Boot.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
