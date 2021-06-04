package com.jzjr.asyncoperation.service.impl;

import com.jzjr.asyncoperation.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void asyncNoResult() throws InterruptedException {
        Thread.sleep(3000);
        log.info("短信通知成功");
        Thread.sleep(3000);
        log.info("积分增加成功");
    }
}
