package sharding.jdbc.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import sharding.jdbc.sample.entity.Udict;

@Repository
public interface UdictMapper extends BaseMapper<Udict> {
}
