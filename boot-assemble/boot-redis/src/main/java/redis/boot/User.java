package redis.boot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/6
 */
@Data
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable {
    Integer id;
    String userName;
}
