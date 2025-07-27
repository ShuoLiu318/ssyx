package com.ssyx.sys.service;

import com.ssyx.model.model.sys.Region;

import java.util.List;

/**
 * @author gray
 * @date 20/07/2025
 * @description
 */
public interface RegionService {

    //根据关键字获取地区列表
    List<Region> findRegionByKeyword(String keyword);

}
