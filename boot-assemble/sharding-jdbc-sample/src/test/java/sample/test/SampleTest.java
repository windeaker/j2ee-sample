package sample.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sharding.jdbc.sample.ShardingJDBCSampleBootstrap;
import sharding.jdbc.sample.entity.Course;
import sharding.jdbc.sample.entity.Udict;
import sharding.jdbc.sample.entity.User;
import sharding.jdbc.sample.mapper.CourseMapper;
import sharding.jdbc.sample.mapper.UdictMapper;
import sharding.jdbc.sample.mapper.UserMapper;

import java.util.Random;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/30
 */
@SpringBootTest(classes = ShardingJDBCSampleBootstrap.class)
@RunWith(SpringRunner.class)
public class SampleTest {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;

    //======================测试公共表===================
    //添加操作
    @Test
    public void addDict() {
        Udict udict = new Udict();
        udict.setUstatus("a");
        udict.setUvalue("已启用");
        udictMapper.insert(udict);
    }

    //删除操作
    @Test
    public void deleteDict() {
        QueryWrapper<Udict>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("dictid",465191484111454209L);
        udictMapper.delete(wrapper);
    }

    //======================测试垂直分库==================
    //添加操作
    @Test
    public void addUserDb() {
        User user = new User();
        user.setUsername("lucymary");
        user.setUstatus("a");
        userMapper.insert(user);
    }

    //查询操作
    @Test
    public void findUserDb() {
        QueryWrapper<User>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("user_id",465508031619137537L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }


    //======================测试水平分库=====================
    //添加操作
    @Test
    public void addCourseDb() {
        Random random=new Random();
        for(int i=1;i<=5000;i++) {
            Course course = new Course();
            course.setCname("javademo"+i);
            //分库根据user_id
            course.setUserId((long)random.nextInt(1000));
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
    }

    //查询操作
    @Test
    public void findCourseDb() {
        QueryWrapper<Course>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("cname","javademo4978");
        //实际上执行了4次查询
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }

    //=======================测试水平分表===================


    @Test
    public void addCourse(){
        for(int i=1;i<=1000;i++) {
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId(100L);
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
    }

    @Test
    public void queryCourse(){
        QueryWrapper<Course> courseQueryWrapper=new QueryWrapper<>();
        courseQueryWrapper.eq("cname","java816");
        Course result=courseMapper.selectOne(courseQueryWrapper);
        System.out.println(result);
    }
}
