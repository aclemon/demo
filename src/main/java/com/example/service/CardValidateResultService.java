package com.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.CardValidateResult;

/**
 * 验卡结果表(CardValidateResult)表服务接口
 *
 * @author makejava
 * @since 2021-04-20 15:19:15
 */
public interface CardValidateResultService extends IService<CardValidateResult> {

    public boolean insertFourOrUpdate(CardValidateResult cardValidateResult);


    /**
     * <p>
     * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * 此次修改主要是减少了此项业务代码的代码量（存在性验证之后的saveOrUpdate操作）
     * </p>
     *
     * @param entity 实体对象
     */
    default boolean saveOrUpdateByCondition(CardValidateResult entity, Wrapper<CardValidateResult> updateWrapper) {
        return update(entity, updateWrapper) || saveOrUpdate(entity);
    }
}
