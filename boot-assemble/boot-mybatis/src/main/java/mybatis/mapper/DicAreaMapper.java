package mybatis.mapper;


import mybatis.DicArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DicAreaMapper {

    @Select("select * from dic_area limit #{offset},#{size};")
    List<DicArea> selectAll(@Param("offset")int offset,@Param("size") int size);

}
