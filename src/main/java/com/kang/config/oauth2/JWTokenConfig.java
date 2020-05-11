package com.kang.config.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.kang.common.constant.Oauth2Constant;

/**
 * <p>Title: JWTokenConfig</p>
 * <p>Description: 使用JWT替换默认的令牌（默认令牌使用UUID生成）只需要指定TokenStore为JwtTokenStore即可<p>
 * @author ChaoKang
 * @date 2020年5月10日
 */
@Configuration
public class JWTokenConfig {

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(Oauth2Constant.SIGNING_KEY); // 签名密钥
        return accessTokenConverter;
    }
    
    /**
     * <p>Title: tokenEnhancer</p>
     * <p>Description: JWT添加信息的Bean(token增强器)</p>
     * @param @return
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new JWTokenEnhancer();
    }
}
