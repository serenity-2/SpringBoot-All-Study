package com.jzjr.reidsoperation;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ReidsoperationApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        long time = new Date().getTime();
        System.out.println(time);
    }

    /**
     * String相关操作
     */
    @Test
    public void stringOperation() {

        //通过redisTemplate设置值
        //方法1
        redisTemplate.boundValueOps("StringKey").set("StringValue");
        redisTemplate.boundValueOps("StringKeyTime").set("StringValueTime", 1, TimeUnit.MINUTES);

        //方法2
        redisTemplate.opsForValue().set("key", "value");
        redisTemplate.opsForValue().set("ONE", 1, 1, TimeUnit.MINUTES);

        //单独设置过期时间(没有对应的key值也不会报错)
        redisTemplate.boundValueOps("StringKey").expire(1, TimeUnit.MINUTES);
        redisTemplate.expire("key", 1, TimeUnit.MINUTES);

        //获取值
        String value = (String) redisTemplate.boundValueOps("StringKey").get();
        System.out.println(value);

        String vvlue = (String) redisTemplate.opsForValue().get("StringKey");
        System.out.println(vvlue);

        //删除key
        Boolean result = redisTemplate.delete("StringKey");
        System.out.println(result);
    }

    /**
     * hash类型相关操作
     */
    @Test
    public void hashOperation() {
        //设置值
        redisTemplate.opsForHash().put("HashKey", "SmallKey", "Value");
        redisTemplate.opsForHash().put("HashKey", "SsmallKey", "Vvalue");

        redisTemplate.boundHashOps("tuesday").put("SmallKey", "Value");
        redisTemplate.boundHashOps("tuesday").put("SsmallKey", "Vvalue");

        //过期时间只能单独设置
        redisTemplate.expire("tuesday", 1, TimeUnit.MINUTES);

        redisTemplate.boundHashOps("tuesday").expire(1, TimeUnit.MINUTES);

        //添加一个map
        HashMap<Object, Object> map = new HashMap<>();
        map.put("shanghai","lujiazui");
        map.put("beijing","guomao");
        map.put("sanfrancisco","guigu");
        redisTemplate.boundHashOps("technology").putAll(map);
        redisTemplate.opsForHash().putAll("technology",map);

        //提取所有的key
        Set city = redisTemplate.opsForHash().keys("technology");
        Set cities = redisTemplate.boundHashOps("technology").keys();
        System.out.println(cities);

        //根据key获取value
        String c = (String) redisTemplate.boundHashOps("technology").get("shanghai");
        String ci = (String) redisTemplate.opsForHash().get("technology", "beijing");
        System.out.println(ci);

        //获取所有键值对集合
        Map entries = redisTemplate.opsForHash().entries("technology");
        Map entries1 = redisTemplate.boundHashOps("technology").entries();
        System.out.println(entries1);

        //删除小key
        redisTemplate.boundHashOps("technology").delete("beijing");
        redisTemplate.opsForHash().delete("technology","shanghai");

        //删除大key
        redisTemplate.delete("technology");

        //判断key中是否存在该值
        Boolean result = redisTemplate.boundHashOps("technology").hasKey("shanghai");
        Boolean rresult = redisTemplate.opsForHash().hasKey("technology", "beijing");

        System.out.println(result);
        System.out.println(rresult);
    }
    /**
     * set类型相关操作
     */
    @Test
    public void setOperation(){

        //设置值
        redisTemplate.opsForSet().add("color","red","orange","yellow","green","blue","indigo","purple");
        redisTemplate.boundSetOps("future").add("life sciences","biological medicine","space exploration");

        //单独设置过期时间
        redisTemplate.boundSetOps("color").expire(60,TimeUnit.SECONDS);
        redisTemplate.expire("future",60,TimeUnit.SECONDS);

        //根据key获得set中的所有值
        Set color = redisTemplate.boundSetOps("color").members();
        System.out.println(color);
        Set future = redisTemplate.opsForSet().members("future");
        System.out.println(future);

        //根据value查询set中是否存在
        Boolean member = redisTemplate.boundSetOps("color").isMember("blue");
        System.out.println(member);
        Boolean member1 = redisTemplate.opsForSet().isMember("future", "life sciences");
        System.out.println(member1);

        //获取set缓存的长度
        Long size = redisTemplate.opsForSet().size("color");
        System.out.println(size);
        Long size1 = redisTemplate.boundSetOps("future").size();
        System.out.println(size1);

        //删除set中指定value
        redisTemplate.boundSetOps("color").remove("purple");
        redisTemplate.opsForSet().remove("future","life sciences");

        //删除整个set
        redisTemplate.delete("color");
    }

    /**
     * List类型相关操作
     */
    @Test
    public void listOperation(){

        //顺序为先进后出：4 3 1 2
        redisTemplate.opsForList().leftPush("listKey","value1");
        redisTemplate.opsForList().leftPush("listKey","value3");
        redisTemplate.opsForList().leftPush("listKey","value4");
        redisTemplate.opsForList().rightPush("listKey","value2");

        redisTemplate.boundListOps("flower").leftPush("lily");

        //将list添加缓存
        List<String> flowers = Arrays.asList("lily", "rose", "peony");
        redisTemplate.opsForList().leftPushAll("flowers",flowers);
        redisTemplate.boundListOps("flowers").leftPushAll(flowers);

        //获取list缓存的长度
        Long size = redisTemplate.opsForList().size("flowers");

        //设置过期时间，单独设置
        redisTemplate.boundListOps("flowers").expire(1,TimeUnit.MINUTES);

        //获取值(起始索引，结束索引)
        List list = redisTemplate.boundListOps("flowers").range(0, flowers.size());
        redisTemplate.opsForList().range("flowers",0,flowers.size());

        //从左侧或右侧弹出一个元素
        JSONArray flowers2 = (JSONArray) redisTemplate.opsForList().leftPop("flowers");
        String flowers1 = (String) redisTemplate.boundListOps("flowers").rightPop();

        //根据索引查询元素
        String flowers3 = (String) redisTemplate.boundListOps("flowers").index(0);

        //根据索引修改List中某条数据的值
        redisTemplate.opsForList().set("flowers",0,"sakura");

        //移除N个值为value的元素
        Long count = redisTemplate.boundListOps("flowers").remove(1L, "sakura");
    }

    /**
     * ZSET类型相关操作
     */
    @Test
    public void sizeOperation(){

        //集合中添加元素(需指定double类型的score,值越大,排序越靠前)
        redisTemplate.opsForZSet().add("benke","lisanshuxue",1);
        redisTemplate.opsForZSet().add("benke","shujukexitongyuanli",4);
        redisTemplate.boundZSetOps("benke").add("shujujiegou",2);
        redisTemplate.boundZSetOps("benke").add("jisuanjiwangluo",3);

       //按排名从小到大获取指定区间内的元素，-1为打印全部
        Set benke = redisTemplate.boundZSetOps("benke").range(0, -1);

        //按排名从大到小获取指定区间内的元素，-1为打印全部
        Set benke2 = redisTemplate.opsForZSet().reverseRange("benke", 0, -1);

        //设置过期时间
        redisTemplate.boundZSetOps("benke").expire(1,TimeUnit.SECONDS);

        //为指定元素加分
        redisTemplate.boundZSetOps("benke").incrementScore("lisanshuxue",5);

        //从集合中删除指定元素
        Long remove = redisTemplate.opsForZSet().remove("benke", "shujukexitongyuanli");

        //删除指定范围内的数据
        Long benke1 = redisTemplate.boundZSetOps("benke").removeRangeByScore(5, 6);
    }
}
