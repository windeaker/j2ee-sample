package mybatis.simple.mapper;

import java.util.List;
import mybatis.simple.pojo.SysAccount;
import mybatis.simple.pojo.SysAccountExample;
import org.apache.ibatis.annotations.Param;

public interface SysAccountMapper {
    long countByExample(SysAccountExample example);

    int deleteByExample(SysAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAccount record);

    int insertSelective(SysAccount record);

    List<SysAccount> selectByExample(SysAccountExample example);

    SysAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByExample(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByPrimaryKeySelective(SysAccount record);

    int updateByPrimaryKey(SysAccount record);
}