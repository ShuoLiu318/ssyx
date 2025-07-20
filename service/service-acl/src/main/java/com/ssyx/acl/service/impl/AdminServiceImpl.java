package com.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.acl.mapper.AdminMapper;
import com.ssyx.acl.service.AdminService;
import com.ssyx.model.model.acl.Admin;
import com.ssyx.model.vo.acl.AdminQueryVo;
import org.springframework.stereotype.Service;

/**
 * @author gray
 * @date 19/07/2025
 * @description
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo) {
        //获取用户名称条件值
        String name = userQueryVo.getName();
        //创建条件构造器
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name), Admin::getName, name);
        //调用mapper方法
        return baseMapper.selectPage(pageParam, wrapper);
    }

}
