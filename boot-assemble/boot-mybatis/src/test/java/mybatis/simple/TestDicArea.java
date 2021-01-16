package mybatis.simple;

import mybatis.simple.mapper.DicAreaMapper;
import mybatis.simple.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MybatisBootstrap.class)
@TestPropertySource("classpath:application-simple.properties")
@RunWith(SpringRunner.class)
public class TestDicArea {
    @Autowired
    DicAreaMapper dicAreaMapper;

    @Autowired
    AccountService accountService;

    @Test
    public void insertAccount(){
        accountService.insertAccountByTransaction();
    }
}
