package com.example.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.dao.CardValidateResultDao;
import com.example.entity.CardValidateResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: w00990
 * @Date: 2021/4/20
 */
@Slf4j
@SpringBootTest
class CardValidateResultServiceTest {
    @Resource
    private CardValidateResultService cardValidateResultService;
    @Resource
    private CardValidateResultDao cardValidateResultDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     */
    @Test
    void listObjs() {
        CardValidateResult c123 = CardValidateResult.builder()
                .certId("C12456")
                .custNo("12345")
                .mobileNo("1234")
                .bankCardNo("123")
                .idNo("1234567")
                .custName("KKuh")
                .verifyStatus("01")
                .smsStatus("04")
                .validMethod("02")
                .build();
//        log.info("sdfafasd");
//        cardValidateResultDao.
        UpdateWrapper<CardValidateResult> objectUpdateWrapper = new UpdateWrapper<>();
        objectUpdateWrapper.eq("id_no", c123.getIdNo());
        objectUpdateWrapper.eq("cust_no", c123.getCustNo());
        cardValidateResultService.saveOrUpdate(c123, objectUpdateWrapper);
//        cardValidateResultService.saveOrUpdateByCondition(c123, objectUpdateWrapper);
//        cardValidateResultService.insertFourOrUpdate(c123);
    }
}
