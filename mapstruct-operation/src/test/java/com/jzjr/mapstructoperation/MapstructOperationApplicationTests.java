package com.jzjr.mapstructoperation;

import com.jzjr.mapstructoperation.bo.PersonPO;
import com.jzjr.mapstructoperation.bo.SysUsers;
import com.jzjr.mapstructoperation.convert.PersonConverter;
import com.jzjr.mapstructoperation.dbobject.Person;
import com.jzjr.mapstructoperation.dbobject.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@SpringBootTest
class MapstructOperationApplicationTests {
  @Resource
  private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        Person sandy = new Person(1L, "SANDY", "SANDY@163.com", new Date(), new User(24));
        PersonPO personPO = PersonConverter.INSTANCE.domain2dto(sandy);
        Assertions.assertNotNull(personPO);
        Assertions.assertEquals(personPO.getId(),sandy.getId());
        Assertions.assertEquals(personPO.getBirth(),sandy.getBirthday());
        Assertions.assertEquals(personPO.getAge(),sandy.getUser().getAge());
        Assertions.assertEquals(personPO.getEmail(),sandy.getEmail());
    }

    @Test
    public void testTimeout() {
        Object o = null;
        try {
        URL url = new URL("http://127.0.0.1:8088/user/save");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId","11");
        map.put("userName","Helen");
        SysUsers sysUsers = new SysUsers();
        o = restTemplate.postForObject(String.valueOf(url), map, String.class);
        } catch (RestClientException | MalformedURLException e) {
            log.error("调用远程接口发生错误：{}",e.getMessage());
            e.printStackTrace();
        }
        System.out.println(o);
    }

}
