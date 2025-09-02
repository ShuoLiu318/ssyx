package com.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.product.Category;
import com.ssyx.model.vo.product.CategoryQueryVo;

import java.util.List;

/**
 * @author gray
 * @date 02/09/2025
 * @description
 */
public interface CategoryService extends IService<Category> {

    //商品分类分页列表
    IPage<Category> selectPage(Page<Category> pageParam, CategoryQueryVo categoryQueryVo);

    //查询所有商品分类
    List<Category> findAllList();

}
