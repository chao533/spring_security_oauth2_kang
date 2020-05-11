package com.kang.config.oauth2.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.kang.common.msg.ErrorCode;
import com.kang.common.msg.Message;
import com.kang.common.utils.ResponseUtils;

import cn.hutool.json.JSONUtil;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		Message<?> mess = new Message<>(ErrorCode.ERROR_LOGIN,exception.getMessage());
		ResponseUtils.responseResult(response, JSONUtil.toJsonStr(mess));
	}
}
