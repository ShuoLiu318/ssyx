package com.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.product.SkuInfo;
import com.ssyx.model.vo.product.SkuInfoQueryVo;
import com.ssyx.model.vo.product.SkuInfoVo;

/**
 * @author gray
 * @date 02/09/2025
 * @description
 */
public interface SkuInfoService extends IService<SkuInfo> {
    //获取sku分页列表
    IPage<SkuInfo> selectPage(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    //添加商品
    void saveSkuInfo(SkuInfoVo skuInfoVo);
}
