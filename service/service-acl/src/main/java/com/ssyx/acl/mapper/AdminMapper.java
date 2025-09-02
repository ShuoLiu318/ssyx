package com.ssyx.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssyx.model.model.acl.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author gray
 * @date 19/07/2025
 * @description
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}