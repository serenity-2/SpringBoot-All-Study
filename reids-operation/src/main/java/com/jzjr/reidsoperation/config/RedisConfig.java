package com.jzjr.reidsoperation.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.nio.charset.Charset;

@Configuration
public class RedisConfig {

    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        //初始化设置序列化工具
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        JsonRedisSerializer jsonRedisSerializer = new JsonRedisSerializer(Object.class);
        //配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 内部类,序列化、反序列化转换器
     * @param <T>
     */
    private static class JsonRedisSerializer<T> implements RedisSerializer<T> {
         private final Class<T>clazz;
         private final Charset defaultCharset;

         public JsonRedisSerializer(Class<T>clazz){
             super();
             this.clazz = clazz;
             this.defaultCharset =Charset.forName("UTF-8");
         }

        /**
         * 序列化
         * @param t
         * @return
         * @throws SerializationException
         */
        @Override
        public byte[] serialize(T t) throws SerializationException {
            if (t == null){
                return new byte[0];
            }
         return JSONObject.toJSONString(t, SerializerFeature.WriteClassName).getBytes(defaultCharset);
        }

        /**
         * 反序列化
         * @param bytes
         * @return
         * @throws SerializationException
         */
        @Override
        public T deserialize(byte[] bytes) throws SerializationException {
            if (bytes == null || bytes.length <= 0){
                return null;
            }
          return JSONObject.parseObject(new String(bytes,defaultCharset),clazz, Feature.SupportAutoType);
        }
    }
}
