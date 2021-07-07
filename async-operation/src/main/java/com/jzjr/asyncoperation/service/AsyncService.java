package com.jzjr.asyncoperation.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.ExecutionException;

public interface AsyncService {
    @Async
    void asyncNoResult() throws InterruptedException;

    Integer asyncHaveResult() throws InterruptedException, ExecutionException;

}
