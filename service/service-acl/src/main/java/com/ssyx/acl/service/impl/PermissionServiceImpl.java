package com.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.acl.helper.PermissionHelper;
import com.ssyx.acl.mapper.PermissionMapper;
import com.ssyx.acl.mapper.RolePermissionMapper;
import com.ssyx.acl.service.PermissionService;
import com.ssyx.acl.service.RolePermissionService;
import com.ssyx.model.model.acl.Permission;
import com.ssyx.model.model.acl.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gray
 * @date 20/07/2025
 * @description
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    //获取所有菜单
    @Override
    public List<Permission> queryAllMenu() {
        //获取全部权限数据
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));
        //把权限数据构建成树形结构数据
        return PermissionHelper.build(allPermissionList);
    }

    //递归删除菜单
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRolePermission(Long roleId, Long[] permissionIds) {
        //删除用户分配的角色数据
        LambdaQueryWrapper<RolePermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RolePermission::getRoleId, roleId);
        rolePermissionMapper.delete(queryWrapper);
        //分配新的角色
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            if (permissionId == null) continue;
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionList.add(rolePermission);
        }
        return rolePermissionService.saveBatch(rolePermissionList);
    }

    @Override
    public List<Permission> findPermissionByRoleId(Long roleId) {
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));
        List<Long> rolePermissionByRoleId = rolePermissionMapper.findRolePermissionByRoleId(roleId);
        for (Permission permission : allPermissionList) {
            if (rolePermissionByRoleId.contains(permission.getId())) {
                permission.setSelect(true);
            }
        }
        return PermissionHelper.build(allPermissionList);
    }

    /**
     * 递归获取子节点
     *
     * @param id
     * @param idList
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }
}
