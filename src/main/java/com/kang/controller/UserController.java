package com.kang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kang.common.msg.ErrorCode;
import com.kang.common.msg.Message;
import com.kang.common.utils.JwtUtils;

@RestController
public class UserController {

	@GetMapping("index")
	public Object index() {
	    return new Message<>(ErrorCode.SUCCESS,JwtUtils.getUser());
	}
	
	@GetMapping("demo")
	public Object demo() {
		return new Message<>(ErrorCode.SUCCESS);
	}
}
