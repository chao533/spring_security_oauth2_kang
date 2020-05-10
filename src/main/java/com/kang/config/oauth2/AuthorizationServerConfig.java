package com.kang.config.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.kang.common.constant.Oauth2Constant;
import com.kang.service.UserDetailService;

/**
 * <p>Title: AuthorizationServerConfig</p>
 * <p>Description: 认证服务器<p>
 * @author ChaoKang
 * @date 2020年5月10日
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private TokenStore jwtTokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer tokenEnhancer;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		// 将这些Bean放入认证服务器里
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		List<TokenEnhancer> enhancers = new ArrayList<>();
		enhancers.add(tokenEnhancer);
		enhancers.add(jwtAccessTokenConverter);
		enhancerChain.setTokenEnhancers(enhancers);

		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userDetailService)
				.tokenStore(jwtTokenStore)
				.accessTokenConverter(jwtAccessTokenConverter)
				.tokenEnhancer(enhancerChain);
	}

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(Oauth2Constant.CLIENT)
                .secret(new BCryptPasswordEncoder().encode(Oauth2Constant.SECRET)) // 放入原密码会报错
                .accessTokenValiditySeconds(Oauth2Constant.ACCESS_TOKEN) // 3600秒过期
                .refreshTokenValiditySeconds(Oauth2Constant.REFRESH_TOKEN) // 7200秒过期
                .scopes(Oauth2Constant.SCOPES)
                .authorizedGrantTypes(Oauth2Constant.GRANT_TYPES)
            .and()
                .withClient("test2")
                .secret(new BCryptPasswordEncoder().encode("test2222")) 
                .accessTokenValiditySeconds(7200);
    }
}