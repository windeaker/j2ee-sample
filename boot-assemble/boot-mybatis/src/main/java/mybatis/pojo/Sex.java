package mybatis.pojo;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/1
 */
public enum  Sex {
    MALE(1,"男"),FEMALE(0,"女");
    private int id;
    private String name;

    private Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

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


    public static Sex getSex(int id){
        if (id==1){
            return MALE;
        }else if (id==2) {
            return FEMALE;
        }else {
            throw new RuntimeException("");
        }
    }
}
