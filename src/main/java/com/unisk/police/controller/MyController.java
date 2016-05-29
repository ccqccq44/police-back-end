package com.unisk.police.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unisk.police.service.InvokeAntifraud;
//测试一下修改而已
//再次测试一下
//测试完毕
@Controller
public class MyController {
	private static final Logger logger= LoggerFactory.getLogger(MyController.class);
			
	@ResponseBody      //校验用户名密码
	@RequestMapping(value="/login",consumes="application/json;charset=utf-8",
	produces="application/json,charset=UTF-8",method=RequestMethod.POST)
	public  String  login(HttpServletRequest req,HttpServletResponse rep) throws Exception {		
		String result = null;	
		//获得前端发过来的请求中的内容
		String reqBody = getRequestBody(req); 
		logger.info("发送过来的username,password为："+reqBody);
		if (reqBody==null||"{}".equals(reqBody)) {			
			logger.info("用户名密码请求消息内容为空");
			return null;
		}    
		result=InvokeAntifraud.checkUser(reqBody);	    			
		return result;	
	}
	
	@ResponseBody      //police回访界面获取数据
	@RequestMapping(value="/selectExpatriatelist",consumes="application/json;charset=utf-8",
			produces="application/json,charset=UTF-8",method=RequestMethod.POST)
	public  String  selectExpatriatelist(HttpServletRequest req,HttpServletResponse rep) throws Exception {		
		String result = null;	
		//获得前端发过来的请求中的内容
		String reqBody = getRequestBody(req); 
		logger.info("发送过来的获取portallist的sessionid和用户名为："+reqBody);
		if (reqBody==null||"{}".equals(reqBody)) {			
			logger.info("公安获取数据请求消息内容为空");
			return null;
		}    
		result=InvokeAntifraud.getPortallist(reqBody);
		logger.info("返回给前端的portallist数据为："+result);
		return result;	
	}
	
	@ResponseBody      //police回访处理完数据插入数据库
	@RequestMapping(value="/insertPolicelist",consumes="application/json;charset=utf-8",
			produces="application/json,charset=UTF-8",method=RequestMethod.POST)
	public void insertPolicelist(HttpServletRequest req,HttpServletResponse rep) throws Exception {		
//		String userResult = null;	
		//获得前端发过来的请求中的内容
		String reqBody = getRequestBody(req); 
		logger.info("发送过来的deallist为："+reqBody);
//		if (reqBody==null||"".equals(reqBody)) {			
//			System.out.println("公安获取数据请求消息内容为空");
//			return null;
//		}    
		InvokeAntifraud.insertPolicelist(reqBody);	    			
//		return userResult;	
	}
	
	@ResponseBody      //police查询处理完的数据
	@RequestMapping(value="/selectPolicelist",consumes="application/json;charset=utf-8",
			produces="application/json,charset=UTF-8",method=RequestMethod.POST)
	public  String  selectPolicelist(HttpServletRequest req,HttpServletResponse rep) throws Exception {		
		String result = null;	
		//获得前端发过来的请求中的内容
		String reqBody = getRequestBody(req); 
		logger.info("发送过来的selectPhone为："+reqBody);
		if (reqBody==null||"{}".equals(reqBody)) {			
			logger.info("公安获取数据请求消息内容为空");
			return null;
		}    
		result=InvokeAntifraud.selectPolicelist(reqBody);	    			
		return result;	
	}
	
	private String getRequestBody(HttpServletRequest req) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){sb.append(line);}
        String reqBody = sb.toString();
		return reqBody;
	}
}
	
	
	
	