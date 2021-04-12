package security2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class Security2Boot {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream in= Security2Boot.class.getClassLoader().getResourceAsStream("application-2.properties");
        properties.load(in);
        SpringApplication springApplication=new SpringApplication(Security2Boot.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
