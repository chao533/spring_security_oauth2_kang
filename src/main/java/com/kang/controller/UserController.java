package com.kang.controller;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kang.common.constant.Oauth2Constant;

import io.jsonwebtoken.Jwts;

@RestController
public class UserController {

	@GetMapping("index")
	public Object index(@AuthenticationPrincipal Authentication authentication, HttpServletRequest request) {
	    String header = request.getHeader("Authorization");
	    String token = StringUtils.substringAfter(header, "bearer ");

	    return Jwts.parser().setSigningKey(Oauth2Constant.SIGNING_KEY.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
	}
}
