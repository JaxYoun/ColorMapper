package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.ValidateCodeUtil;

@RestController
@RequestMapping(value="/validCode")
public class ValidCodeController {

	@PostMapping(value="/getValidateCode")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();

		ValidateCodeUtil.getDefaultValidateCode();
		session.removeAttribute("validateCode");
		try {
			ValidateCodeUtil.write(response.getOutputStream());
			session.setAttribute("validateCode", ValidateCodeUtil.getCode());
			ValidateCodeUtil.write(response.getOutputStream());
			System.err.println(ValidateCodeUtil.getCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
