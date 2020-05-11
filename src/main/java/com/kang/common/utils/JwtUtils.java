package com.kang.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kang.common.constant.Oauth2Constant;

import io.jsonwebtoken.Jwts;

public class JwtUtils {

	
	public static Map<String,Object> getUser(){
		String header = getRequest().getHeader("Authorization");
	    String token = StringUtils.substringAfter(header, "Bearer ");
	    Map<String,Object> body = Jwts.parser().setSigningKey(Oauth2Constant.SIGNING_KEY.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
	    body.remove("exp");
	    return body;
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
