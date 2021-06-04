package com.jzjr.asyncoperation.controller;

import com.jzjr.asyncoperation.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/noresult")
    public String asyncNoResult() {
        log.info("提交订单");
        log.info("支付开始");
        try {
            asyncService.asyncNoResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("订单处理失败");
            return "订单处理失败";
        }
        log.info("扣款成功");
        log.info("订单关闭");
        return "订单处理成功";
    }
}
