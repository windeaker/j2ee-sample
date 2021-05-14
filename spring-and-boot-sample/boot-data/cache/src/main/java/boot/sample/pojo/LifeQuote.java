package boot.sample.pojo;

import lombok.*;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LifeQuote {
    Integer id;
    String title;
    Integer hits;
}
