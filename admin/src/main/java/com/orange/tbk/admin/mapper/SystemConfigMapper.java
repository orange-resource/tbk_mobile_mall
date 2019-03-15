package com.orange.tbk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.tbk.api.bean.SystemConfig;
import com.orange.tbk.api.vo.open.SystemConfigVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    @Select("select contact,about,footer from t_system_config")
    SystemConfigVo getSystemConfigVo();

}