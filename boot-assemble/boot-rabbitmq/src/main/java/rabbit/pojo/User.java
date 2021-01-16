package rabbit.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/4
 */
@Data
@Builder
@ToString
public class User implements Serializable {
    Integer id;
    String userName;
}
