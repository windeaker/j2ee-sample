package mybatis.mapper;

import java.util.List;
import mybatis.pojo.DicArea;
import mybatis.pojo.DicAreaExample;
import org.apache.ibatis.annotations.Param;

public interface DicAreaMapper {
    long countByExample(DicAreaExample example);

    int deleteByExample(DicAreaExample example);

    int deleteByPrimaryKey(Long code);

    int insert(DicArea record);

    int insertSelective(DicArea record);

    List<DicArea> selectByExample(DicAreaExample example);

    DicArea selectByPrimaryKey(Long code);

    int updateByExampleSelective(@Param("record") DicArea record, @Param("example") DicAreaExample example);

    int updateByExample(@Param("record") DicArea record, @Param("example") DicAreaExample example);

    int updateByPrimaryKeySelective(DicArea record);

    int updateByPrimaryKey(DicArea record);
}