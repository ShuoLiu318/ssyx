package com.ssyx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.model.model.sys.Region;
import com.ssyx.sys.mapper.RegionMapper;
import com.ssyx.sys.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gray
 * @date 20/07/2025
 * @description
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    //根据关键字获取地区列表
    @Override
    public List<Region> findRegionByKeyword(String keyword) {
        LambdaQueryWrapper<Region> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Region::getName, keyword);
        return baseMapper.selectList(queryWrapper);
    }

}
