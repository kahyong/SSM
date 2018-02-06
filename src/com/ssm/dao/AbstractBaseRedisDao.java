package com.ssm.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.serializer.RedisSerializer;  

/**  
 * redis Dao 
 * @author ck
 */   
public abstract class AbstractBaseRedisDao<K, V> {  
      
    @Autowired
    protected RedisTemplate redisTemplate;
  
    /** 
     * 设置redisTemplate 
     * @param redisTemplate the redisTemplate to set 
     */  
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;  
    }  
      
    /** 
     * 获取 RedisSerializer 
     */  
    protected RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  
    }  
}
