package com.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.acl.mapper.RoleMapper;
import com.ssyx.acl.service.RoleService;
import com.ssyx.model.model.acl.Role;
import com.ssyx.model.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

/**
 * @author gray
 * @date 19/07/2025
 * @description
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo) {
        //获取条件值：角色名称
        String roleName = roleQueryVo.getRoleName();
        //创建条件构造器对象
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        //判断条件值是否为空
        wrapper.like(StringUtils.isNotBlank(roleName), Role::getRoleName, roleName);
        //调用mapper方法实现条件分页查询
        return baseMapper.selectPage(pageParam, wrapper);
    }
}
