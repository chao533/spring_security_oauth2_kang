package com.kang.config.oauth2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * <p>Title: JWTokenEnhancer</p>
 * <p>Description: JWT中添加一些额外的信息<p>
 * @author ChaoKang
 * @date 2020年5月10日
 */
public class JWTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();
        info.put("username", ((User) oAuth2Authentication.getPrincipal()).getUsername());
        info.put("roleName", ((User) oAuth2Authentication.getPrincipal()).getAuthorities());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
