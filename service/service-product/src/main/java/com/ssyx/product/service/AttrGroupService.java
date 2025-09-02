package com.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.product.AttrGroup;
import com.ssyx.model.vo.product.AttrGroupQueryVo;

import java.util.List;

/**
 * @author gray
 * @date 02/09/2025
 * @description
 */
public interface AttrGroupService extends IService<AttrGroup> {

    //平台属性分组列表
    IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo);

    //查询所有属性分组
    List<AttrGroup> findAllList();

}
