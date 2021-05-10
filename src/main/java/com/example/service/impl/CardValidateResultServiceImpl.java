package com.example.service.impl;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.aop.Condition;
import com.example.dao.CardValidateResultDao;
import com.example.entity.CardValidateResult;
import com.example.service.CardValidateResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * 验卡结果表(CardValidateResult)表服务实现类
 *
 * @author makejava
 * @since 2021-04-20 15:19:15
 */
@Slf4j
@Service("cardValidateResultService")
public class CardValidateResultServiceImpl extends ServiceImpl<CardValidateResultDao, CardValidateResult> implements CardValidateResultService {


    @Override
    public boolean insertFourOrUpdate(CardValidateResult cardValidateResult) {
        if (null != cardValidateResult) {
            CardValidateResult cardValidateResultCondition = new CardValidateResult();
            Class<?> cls = cardValidateResult.getClass();
            for (Field f : cls.getDeclaredFields()) {
                if (f.isAnnotationPresent(Condition.class)) {
                    Condition annotation = f.getAnnotation(Condition.class);
                    Console.log(annotation);
                    Object fieldValue = ReflectUtil.getFieldValue(cardValidateResult, f);
                    Console.log("fieldValue=>" + fieldValue);
                    Assert.notEmpty((String) fieldValue, "error: can not execute. because can not find column for id from entity!");
                    ReflectUtil.setFieldValue(cardValidateResultCondition, f, fieldValue);
                }
            }
            QueryWrapper<CardValidateResult> cardValidateResultQueryWrapper = new QueryWrapper<>(cardValidateResultCondition);
            return saveOrUpdateByCondition(cardValidateResult, cardValidateResultQueryWrapper);
        }
        return false;
    }

//    private boolean updateByCondition(CardValidateResult cardValidateResult, CardValidateResult cardValidateResultCondition) {
//        UpdateWrapper<CardValidateResult> cardValidateResultUpdateWrapper = new UpdateWrapper<>(cardValidateResultCondition);
//        return update(cardValidateResult, cardValidateResultUpdateWrapper);
//    }


//    @Override
//    public CardValidateResult getByCondition(CardValidateResult cardValidateResult) {
//        QueryWrapper<CardValidateResult> objectQueryWrapper = new QueryWrapper<>();
//        objectQueryWrapper.lambda().equals(cardValidateResult);
//        return (CardValidateResult) this.<Object>getObj(objectQueryWrapper, null);
//    }

}
