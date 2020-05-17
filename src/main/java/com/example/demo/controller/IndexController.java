package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.FirebaseClientService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private FirebaseClientService firebaseClientService;

	@GetMapping
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}

	@GetMapping("push")
	@ResponseBody
	public String push() throws FirebaseMessagingException, IOException {
		firebaseClientService.push();
		return "Push成功";
	}
}
