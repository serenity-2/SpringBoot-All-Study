package com.jzjr.asyncoperation.service.impl;

import com.jzjr.asyncoperation.service.AsyncService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Override
    public Integer asyncHaveResult() throws InterruptedException, ExecutionException {
        return doAsync();
    }

    @Async
    public Future<Integer> excute02() throws InterruptedException {
        log.info("excute02 starting...");
        Thread.sleep(3000);
        log.info("ecxute02 finish...");
        return AsyncResult.forValue(2);
    }

    @Async
    public Future<Integer> excute01() throws InterruptedException {
        log.info("excute01 starting...");
        Thread.sleep(3000);
        log.info("ecxute01 finish...");
        return AsyncResult.forValue(1);
    }
    public Integer doAsync() throws InterruptedException, ExecutionException {
        Integer i = excute01().get();
        Integer j = excute02().get();
        return i + j;
    }
}
