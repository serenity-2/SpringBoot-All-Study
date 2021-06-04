package com.jzjr.mybatisoperating.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzjr.mybatisoperating.entity.ConfProperties;

@DS(value = "coloan")
public interface ConfigPropertiesMapper extends BaseMapper<ConfProperties> {

}
