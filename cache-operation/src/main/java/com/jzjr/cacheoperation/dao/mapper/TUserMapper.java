package com.jzjr.cacheoperation.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzjr.cacheoperation.model.TUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "users")
public interface TUserMapper extends BaseMapper<TUser> {

    @Cacheable(key = "#id")
    TUser selectById(Integer id);

    @CachePut(key = "#user.id")
    default TUser insertUser(TUser user) {
        this.insert(user);
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);
}
