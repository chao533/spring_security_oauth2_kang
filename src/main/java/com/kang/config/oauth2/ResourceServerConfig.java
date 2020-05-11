package com.kang.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.kang.config.oauth2.handler.MyAuthenticationFailureHandler;
import com.kang.config.oauth2.handler.MyAuthenticationSucessHandler;

/**
 * <p>Title: ResourceServerConfig</p>
 * <p>Description: 资源服务器<p>
 * @author ChaoKang
 * @date 2020年5月10日
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
            .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/demo").permitAll() // 放行
                .antMatchers("/**")
                .authenticated() // 都需要认证
            .and()
                .csrf().disable();
    }
}