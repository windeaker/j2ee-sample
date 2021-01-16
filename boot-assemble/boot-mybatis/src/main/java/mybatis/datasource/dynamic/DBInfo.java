package mybatis.datasource.dynamic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DBInfo {
    private int id;
    private String dbName;
    private String dbIp;
    private int dbPort;
    private String dbUser;
    private String dbPasswd;

}
