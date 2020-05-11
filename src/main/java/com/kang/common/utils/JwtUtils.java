package com.kang.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kang.common.constant.Oauth2Constant;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.map.MapUtil;
import io.jsonwebtoken.Jwts;

public class JwtUtils {

	
	public static Map<String,Object> getUser(){
		String header = getRequest().getHeader(Oauth2Constant.TOKEN_HEADER);
	    String token = StringUtils.substringAfter(header, Oauth2Constant.TOKEN_PREFIX + " ");
	    Map<String,Object> body = Jwts.parser().setSigningKey(Oauth2Constant.SIGNING_KEY.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
	    
	    // 重新构造返回Token存储的信息
	    Map<String,Object> result = Dict.create().set("id", MapUtil.getLong(body, "id")).set("username", MapUtil.getStr(body, "username")).set("roleName", MapUtil.getStr(body, "roleName"));
	    return result;
	}
	
	/**
     *<p>Title: getRequest</p> 
     *<p>Description: 获取Request对象</p> 
     * @return
     */
    public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		return (requestAttributes == null) ? null : ((ServletRequestAttributes) requestAttributes).getRequest();
	}
}
