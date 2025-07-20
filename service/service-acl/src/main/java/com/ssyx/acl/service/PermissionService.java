package com.ssyx.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.acl.Permission;

import java.util.List;

/**
 * @author gray
 * @date 20/07/2025
 * @description 权限服务
 */
public interface PermissionService extends IService<Permission> {

    //获取所有菜单列表
    List<Permission> queryAllMenu();

    //递归删除
    boolean removeChildById(Long id);

    //根据用户id及roleIdList更新rolePermission
    boolean saveRolePermission(Long adminId, Long[] permissionIds);

    //根据roleId获取所有的permission
    List<Permission> findPermissionByRoleId(Long roleId);

}
