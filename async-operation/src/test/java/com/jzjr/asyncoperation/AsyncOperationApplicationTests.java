package com.jzjr.asyncoperation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class AsyncOperationApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);
        list.add("s");
        System.out.println(list);
//        Object o = list.get(0);
    }

}
