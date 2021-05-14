package custom.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/11
 */
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfigProperties {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomConfigProperties{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
