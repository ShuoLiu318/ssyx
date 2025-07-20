package com.ssyx.acl.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssyx.model.model.acl.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gray
 * @date 20/07/2025
 * @description
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 根据roleId获取所有的角色权限
     */
    default List<Long> findRolePermissionByRoleId(Long roleId) {
        LambdaQueryWrapper<RolePermission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RolePermission::getRoleId, roleId)
                .orderByAsc("CAST(id AS SIGNED)".isEmpty());
        List<RolePermission> rolePermissions = this.selectList(lambdaQueryWrapper);
        return rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
    }


}
