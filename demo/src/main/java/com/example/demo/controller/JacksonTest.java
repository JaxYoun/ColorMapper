package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static void getObjectFromString() {
		String jsonString = "{\"id\":1, \"name\":\"youn\", \"age\":12}";
		try {
			User user = objectMapper.readValue(jsonString, User.class);
			System.err.println(user.name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getJsonStringFromObject(){
		User user = new User(75, "yang", 24);
		try {
			System.out.println(objectMapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public static void getListFromString(){
		String arr = "[{\"id\": 1, \"name\": \"youn\"},{\"id\": 1, \"name\": \"youn2\"}]";
		try {
			List<Object> userList = objectMapper.readValue(arr, List.class);
			System.out.println(userList.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		getObjectFromString();
//		getJsonStringFromObject();
		getListFromString();
	}
}
