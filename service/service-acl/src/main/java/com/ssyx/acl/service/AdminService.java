package com.ssyx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssyx.model.model.acl.Admin;
import com.ssyx.model.vo.acl.AdminQueryVo;

/**
 * @author gray
 * @date 19/07/2025
 * @description 用户服务接口
 */
public interface AdminService extends IService<Admin> {
    /**
     * 用户分页列表
     */
    IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo);
}
