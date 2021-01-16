package sharding.jdbc.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import sharding.jdbc.sample.entity.Course;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

}
