package com.jzjr.asyncoperation.service;

import org.springframework.scheduling.annotation.Async;

public interface AsyncService {
    @Async
    void asyncNoResult() throws InterruptedException;
}
