package org.neojo.web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.neojo.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class ExampleController extends BaseController{
	
	@RequestMapping(value="" , produces = "text/html; charset=utf-8")
	@ResponseBody
	public Object test(HttpServletRequest request){
		return "<h2>Hello World</h2>";
	}
	
	@RequestMapping(value="/1")
	public Object test1(){
		return "showUser";
	}
	
	@RequestMapping(value="/2", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object test2(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		return new Gson().toJson(req.getParameterMap());
	}
}
