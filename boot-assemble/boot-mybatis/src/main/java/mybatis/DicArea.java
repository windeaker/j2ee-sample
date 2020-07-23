package mybatis;


import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DicArea {
    private long code;
    private String name;
    private int level;
    private String fullname;

}
