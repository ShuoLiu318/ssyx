package com.ssyx.acl.helper;

import com.ssyx.model.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gray
 * @date 20/07/2025
 * @description 根据权限数据构建菜单数据
 */
public class PermissionHelper {
    /**
     * 使用递归方法建菜单
     *
     * @param treeNodes
     * @return
     */
    public static List<Permission> build(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>();
        for (Permission treeNode : treeNodes) {
            if (treeNode.getPid() == 0) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {
        treeNode.setChildren(new ArrayList<>());

        for (Permission it : treeNodes) {
            if (treeNode.getId().longValue() == it.getPid().longValue()) {
                it.setLevel(treeNode.getLevel() + 1);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
