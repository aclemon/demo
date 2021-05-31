package com.example.service.impl;

import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.annotation.Condition;
import com.example.service.WService;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

/**
 * @Author: w00990
 * @Date: 2021/4/25
 */
public class WServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements WService<T> {
//    @Autowired
//    protected M baseMapper;

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     * @return boolean
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateByAnnotation(T entity) throws InstantiationException, IllegalAccessException {
        if (null != entity) {
            Class<?> cls = entity.getClass();
            T obj = (T) cls.newInstance();
            for (Field f : cls.getDeclaredFields()) {
                if (f.isAnnotationPresent(Condition.class)) {
                    // todo 根据Group进行筛选
//                    Condition annotation = f.getAnnotation(Condition.class);
                    Object fieldValue = ReflectUtil.getFieldValue(entity, f);
                    ReflectUtil.setFieldValue(obj, f, fieldValue);
                    // 后续校验规则自己进行校验
//                    Assert.notEmpty((String) fieldValue, "error: can not execute. because can not find column for id from entity!");
                }
            }
            QueryWrapper<T> entityQueryWrapper = new QueryWrapper<>(obj);
            return saveOrUpdateByCondition(entity, entityQueryWrapper);
        }
        return false;
    }
}
