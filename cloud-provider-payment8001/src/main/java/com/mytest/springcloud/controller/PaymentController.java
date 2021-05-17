package com.mytest.springcloud.controller;


import com.mytest.springcloud.entities.CommonResult;
import com.mytest.springcloud.entities.Payment;
import com.mytest.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result= paymentService.create(payment);
        log.info("************插入结果：{result}"+result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败");
        }

    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment =paymentService.getPaymentById(id);
        log.info("************插入结果：{payment}"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"无记录");
        }
    }

}
