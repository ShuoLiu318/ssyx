package com.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.model.model.product.Attr;
import com.ssyx.product.mapper.AttrMapper;
import com.ssyx.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gray
 * @date 02/09/2025
 * @description
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {

    //根据属性分组id 获取属性列表
    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId, attrGroupId);
        List<Attr> attrList = baseMapper.selectList(wrapper);
        return attrList;
    }
}
