package com.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.product.Attr;

import java.util.List;

/**
 * @author gray
 * @date 02/09/2025
 * @description
 */
public interface AttrService extends IService<Attr> {

    //根据属性分组id 获取属性列表
    List<Attr> findByAttrGroupId(Long attrGroupId);

}
