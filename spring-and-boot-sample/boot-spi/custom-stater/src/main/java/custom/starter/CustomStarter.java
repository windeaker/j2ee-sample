package custom.starter;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/11
 */
public class CustomStarter {
    int id;
    String name;

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
        return "CustomStarter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
