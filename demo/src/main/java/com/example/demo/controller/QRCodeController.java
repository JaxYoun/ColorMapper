package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/QRCode")
public class QRCodeController {

	private static final Logger logger = Logger.getLogger(ColorMapController.class);
	private static final ObjectMapper jacksonMapper = new ObjectMapper();
	
	public static void main(String[] args) {

	}

}
