package mongo;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
public class MongoUtil {

    @Autowired
    MongoTemplate mongoTemplate;

    public MongoDatabase getDB(){
       return mongoTemplate.getDb();
    }
    public String getDbName(){
        return mongoTemplate.getDb().getName();
    }

    public void createCollection(String collectionName){
        mongoTemplate.createCollection(collectionName);
    }
    public void createCollection(String collectionName, CollectionOptions collectionOptions){
        mongoTemplate.createCollection(collectionName,collectionOptions);
    }
    public void dropCollection(String collectionName){
        mongoTemplate.dropCollection(collectionName);
    }

    public <T> void insert(T object,String collectionName){
        mongoTemplate.insert(object);
    }

    public <T> void insertMany(T... objects){

    }

    public <T> void insertMany(Collection<T> collections){

    }
}
