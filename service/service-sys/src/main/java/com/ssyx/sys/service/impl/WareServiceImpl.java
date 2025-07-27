package com.ssyx.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssyx.model.model.sys.Ware;
import com.ssyx.sys.mapper.WareMapper;
import com.ssyx.sys.service.WareService;
import org.springframework.stereotype.Service;

/**
 * @author gray
 * @date 20/07/2025
 * @description
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {
}
