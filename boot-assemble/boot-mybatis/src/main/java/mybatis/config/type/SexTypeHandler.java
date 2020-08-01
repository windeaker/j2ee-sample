package mybatis.config.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

/**
 * @author windeaker
 */
@MappedTypes(Sex.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class SexTypeHandler extends BaseTypeHandler<Sex> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    @Override
    public Sex getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Sex.getSex(rs.getInt(columnName));
    }

    @Override
    public Sex getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Sex.getSex(rs.getInt(columnIndex));
    }

    @Override
    public Sex getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Sex.getSex(cs.getInt(columnIndex));
    }
}
