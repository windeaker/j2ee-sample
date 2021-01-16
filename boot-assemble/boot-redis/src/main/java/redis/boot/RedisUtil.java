package redis.boot;

import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {


    RedisTemplate redisTemplate;

    ValueOperations valueOperations;

    HashOperations hashOperations;

    ListOperations listOperations;

    SetOperations setOperations;

    ZSetOperations zSetOperations;

    ClusterOperations clusterOperations;

    GeoOperations geoOperations;

    StreamOperations streamOperations;

    @Autowired
    public void getRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
        hashOperations = redisTemplate.opsForHash();
        listOperations = redisTemplate.opsForList();
        setOperations = redisTemplate.opsForSet();
        zSetOperations = redisTemplate.opsForZSet();
        clusterOperations = redisTemplate.opsForCluster();
        geoOperations = redisTemplate.opsForGeo();
        streamOperations = redisTemplate.opsForStream();
    }

    // here started key operations


    public Boolean delKey(Object key) {
        return redisTemplate.delete(key);
    }

    public Boolean existsKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    public byte[] dumpKey(Object key) {
        return redisTemplate.dump(key);
    }

    public Boolean expireKeySeconds(Object key, long seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public Boolean expireKeyTimeStamp(Object key, long timestampWithSeconds) {
        return redisTemplate.expireAt(key, new Date(timestampWithSeconds * 1000));
    }

    public Boolean pExpireKeyMilliseconds(Object key, long milliseconds) {
        return redisTemplate.expire(key, milliseconds, TimeUnit.MILLISECONDS);
    }

    public Boolean pExpireKeyMillisecondsTimestamp(Object key, long timestampWithMilliseconds) {
        return redisTemplate.expireAt(key, new Date(timestampWithMilliseconds));
    }

    public Set<Object> keyPattern(Object pattern) {
        return redisTemplate.keys(pattern);
    }

    public Boolean moveKeyToDB(Object key, int dbIndex) {
        return redisTemplate.move(key, dbIndex);
    }

    public Boolean persistKey(Object key) {
        return redisTemplate.persist(key);
    }

    public Long PTTL(Object key) {
        return redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }

    public Long TTL(Object key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public Object randomKey() {
        return redisTemplate.randomKey();
    }

    public void renameKey(Object key, Object newKeyName) {
        redisTemplate.rename(key, newKeyName);
    }

    public void renameNXkey(Object key, Object newKeyName) {
        redisTemplate.renameIfAbsent(key, newKeyName);
    }

    public DataType typeKey(Object key) {
        return redisTemplate.type(key);
    }

    public void scan() {
        // todo scan命令待查
    }

    // string operation started

    public void set(Object key, Object val) {
        redisTemplate.opsForValue().set(key, val);
    }

    public Object set(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String getRange(Object key, int start, int end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    public Object getSet(Object key, Object newVal) {
        return redisTemplate.opsForValue().getAndSet(key, newVal);
    }

    public Boolean getbit(Object key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    public List mget(Object... key) {
        return redisTemplate.opsForValue().multiGet(Arrays.asList(key));
    }

    public Boolean setbit(Object key, long offset, boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    public void setex(Object key, int expireSeconds, Object value) {
        redisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }

    public Boolean setnx(Object key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public void setrange(Object key, long offset, String value) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    public Long strleng(Object key) {
        return valueOperations.size(key);
    }

    public void mset(Map keyValue) {
        valueOperations.multiSet(keyValue);
    }

    public Boolean msetnx(Map keyValue) {
        return valueOperations.multiSetIfAbsent(keyValue);
    }

    public void psetex(Object key, long milliseconds, Object value) {
        valueOperations.set(key, value, milliseconds, TimeUnit.MILLISECONDS);
    }

    public Long incr(Object key) {
        return valueOperations.increment(key);
    }

    public Long increby(Object key, long delta) {
        return valueOperations.increment(key, delta);
    }

    public Double increbyfloat(Object key, double delta) {
        return valueOperations.increment(key, delta);
    }

    public Long decr(Object key) {
        return valueOperations.decrement(key);
    }

    public Long decrby(Object key, long decrement) {
        return redisTemplate.opsForValue().decrement(key, decrement);
    }

    public Integer append(Object key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    // hash operation started

    public Long hdel(Object key, Object... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    public Boolean hexists(Object key, Object hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public Map hgetall(Object key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public long hincrby(Object key, Object hashKey, long increment) {
        return redisTemplate.opsForHash().increment(key, hashKey, increment);
    }

    public double hincrbyfloat(Object key, Object hashKey, double delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    public Set hkeys(Object key){
        return hashOperations.keys(key);
    }

    public Long hlen(Object key){
        return hashOperations.size(key);
    }

    public List hmget(Object key,Object... hashKeys){
        return hashOperations.multiGet(key,Arrays.asList(hashKeys));
    }

    public void hmset(Object key,Map keyVal){
         hashOperations.putAll(key,keyVal);
    }

    public void hset(Object key,Object hashKey,Object value){
        hashOperations.put(key,hashKey,value);
    }

    public void hsetnx(Object key,Object hashKey,Object value){
        hashOperations.putIfAbsent(key,hashKey,value);
    }


    public Map hvals(Object key) {
        return hashOperations.entries(key);
    }

    //todo 命令待研究
    public Cursor hscan(Object key,ScanOptions scanOptions) {
       return hashOperations.scan(key,scanOptions);
    }

    //list started from here

    public Object blpop(Object key){

        return null;
    }

    public Object brpop(Object key){
        return listOperations.rightPop(key);
    }

    public Object brpoplpush(){

        return null;
    }

    public Object lindex(Object key,long index){
        return listOperations.index(key,index);
    }

    public void linsert(Object key){
//        listOperations.set();
    }

    public Long lleng(Object key){
        return listOperations.size(key);
    }

    public Object lpop(Object key){
        return listOperations.leftPop(key);
    }

    //set started here

    public Long sadd(Object key,Object... member){
       return  setOperations.add(key,member);
    }

    public Long scard(Object key){
        return setOperations.size(key);
    }

    public Set sdiff(Object key1,Object key2){
        return setOperations.difference(key1,key2);
    }

    public Long sdiffstore(Object key1,Object key2,Collections destination){
        return setOperations.differenceAndStore(key1,key2,destination);
    }

    public Set sinter(Object key1,Object key2){
        return setOperations.intersect(key1,key2);
    }

    public Long sinterstore(Object key1,Object key2,Collections destination){
        return setOperations.intersectAndStore(key1,key2,destination);
    }

    public Boolean sismember(Object key,Object member){
        return setOperations.isMember(key,member);
    }

    public Set semembers(Object key){
        return setOperations.members(key);
    }

    public Boolean smove(Object key,Object destination,Object member){
        return setOperations.move(key,member,destination);
    }

    public Object spop(Object key){
        return setOperations.pop(key);
    }

    public List srandmember(Object key,Long count){
        return setOperations.pop(key,count);
    }

    public Long srem(Object key,Object... members){
        return setOperations.remove(key,members);
    }

    public Set sunion(Object key1,Object key2){
        return setOperations.union(key1,key2);
    }

    public Long sunionstore(Object key1,Object key2,Collections destination){
        return setOperations.unionAndStore(key1,key2,destination);
    }

    public void sscan(){

    }

    //zset start here

    public Boolean zadd(Object key,double score ,Object member){
        return zSetOperations.add(key,member,score);
    }

    public Long zcard(Object key){
        return zSetOperations.size(key);
    }

    public Long zcount(Object key,double min,double max){
        return zSetOperations.count(key, min, max);
    }

    public Double zincreby(Object key,double increment,Object value){
        return zSetOperations.incrementScore(key,value,increment);
    }

    public Long zinterstore(){

        return null;
    }

    public List zrange(Object key,double start ,double stop){

        return null;
    }

    public List zrangebyscore(Object key,double start ,double stop){

        return null;
    }

    public List zrank(Object key,Object value){
        return null;
    }

    public Long zrem(Object key,Object... values){
        return zSetOperations.remove(key, values);
    }

    
}
