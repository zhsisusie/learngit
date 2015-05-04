package com.chatRoom.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/tt")
	public void testWriter(HttpServletRequest request,HttpServletResponse response){
		String data="中国";
		try {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			OutputStream stream=response.getOutputStream();
			stream.write(data.getBytes("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
