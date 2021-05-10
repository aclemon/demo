//package com.example.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.api.ApiController;
//import com.baomidou.mybatisplus.extension.api.R;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.entity.CardValidateResult;
//import com.example.service.CardValidateResultService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * 验卡结果表(CardValidateResult)表控制层
// *
// * @author makejava
// * @since 2021-04-20 15:19:15
// */
//@RestController
//@RequestMapping("cardValidateResult")
//public class CardValidateResultController extends ApiController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private CardValidateResultService cardValidateResultService;
//
//    /**
//     * 分页查询所有数据
//     *
//     * @param page               分页对象
//     * @param cardValidateResult 查询实体
//     * @return 所有数据
//     */
//    @GetMapping
//    public R selectAll(Page<CardValidateResult> page, CardValidateResult cardValidateResult) {
//        return success(this.cardValidateResultService.page(page, new QueryWrapper<>(cardValidateResult)));
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public R selectOne(@PathVariable Serializable id) {
//        return success(this.cardValidateResultService.getById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param cardValidateResult 实体对象
//     * @return 新增结果
//     */
//    @PostMapping
//    public R insert(@RequestBody CardValidateResult cardValidateResult) {
//        return success(this.cardValidateResultService.save(cardValidateResult));
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param cardValidateResult 实体对象
//     * @return 修改结果
//     */
//    @PutMapping
//    public R update(@RequestBody CardValidateResult cardValidateResult) {
//        return success(this.cardValidateResultService.updateById(cardValidateResult));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
//    @DeleteMapping
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.cardValidateResultService.removeByIds(idList));
//    }
//}
