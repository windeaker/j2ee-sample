package mybatis.test;

import mybatis.mapper.DicAreaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDicArea {
    @Autowired
    DicAreaMapper dicAreaMapper;

    @Test
    public void selectAllTest(){
//        List<DicArea> dicAreaList=dicAreaMapper.selectAll(0,10);
//        System.out.println(dicAreaList);
    }
}
