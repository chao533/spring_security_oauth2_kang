package com.kang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kang.mapper.mybatis.UserMapper;
import com.kang.model.MyUser;

@Component
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	MyUser record = new MyUser();
    	record.setLoginName(username);
    	MyUser user = userMapper.selectOne(record);
    	if(user == null) {
    		throw new InternalAuthenticationServiceException("该用户不存在");
    	}
        return new User(username, user.getPwd(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList(userMapper.getRoleName(user.getId())));
    }
}
