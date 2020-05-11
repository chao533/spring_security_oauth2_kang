package com.kang.mapper.mybatis;

import org.apache.ibatis.annotations.Select;

import com.kang.common.mapper.BaseMapper;
import com.kang.model.MyUser;

/**
 * <p>Title: UserMapper</p>  
 * <p>Description: 用户Mapper</p>  
 * @author chaokang  
 * @date 2018年12月3日
 */
public interface UserMapper extends BaseMapper<MyUser>{

	@Select(value = "select role_name from tb_role where id = #{roleId}")
	public String getRoleName(Long roleId);
	
}
