package mybatis.datasource.dynamic;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/17
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static synchronized void setDBType(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDBType(){
        return contextHolder.get();
    }

    public static void clearDBType(){
        contextHolder.remove();
    }
}
