package mongo.test;

import com.mongodb.client.MongoDatabase;
import mongo.MongoUtil;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoAssembleTest {
    @Autowired
    MongoUtil mongoUtil;
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void doTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("a",1);
        Document document=new Document();
        document.append("a",1);
//        mongoUtil.insert(document,"temp");
//        mongoTemplate.insert(document);
        mongoTemplate.insert(document,"temp");
    }
}
