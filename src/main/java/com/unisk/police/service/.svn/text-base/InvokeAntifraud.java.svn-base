package com.unisk.police.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;


public class InvokeAntifraud {
	private static final Logger logger= LoggerFactory.getLogger(InvokeAntifraud.class);
	static String url = "http://192.168.1.5:8098/antifraud/";
	
	//校验用户名密码	
	public static String checkUser(String request) throws Exception{	
		String result=null;		
		HttpClient client = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(20000).setConnectTimeout(20000).build();// 设置请求和传输超时时间
	
		HttpPost httpPost = new HttpPost(url+"login");
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type", "application/json");
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("HTTPServer.content", request));
				
		try {
			logger.info("开始发送username,password给内网");
			httpPost.setEntity(new StringEntity(request, "UTF-8"));
			//接收返回数据
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity,"UTF-8");			
			logger.info("校验完username,password后返回的结果为："+result);						
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
			
	}
	
	//获取公安回访界面的数据
	public static String getPortallist(String request) throws Exception{	
		String result=null;		
		HttpClient client = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(20000).setConnectTimeout(20000).build();// 设置请求和传输超时时间
	
		HttpPost httpPost = new HttpPost(url+"selectExpatriatelist");
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type", "application/json");
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("HTTPServer.content", request));
				
		try {
			logger.info("开始向内网请求portallist数据");
			httpPost.setEntity(new StringEntity(request, "UTF-8"));
			//接收返回数据
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity,"UTF-8");			
			logger.info("获取portallist返回的结果为："+result);						
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
			
	}
	
	//公安处理完数据到已处理页面
		public static void insertPolicelist(String request) throws Exception{	
			HttpClient client = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(20000).setConnectTimeout(20000).build();// 设置请求和传输超时时间
		
			HttpPost httpPost = new HttpPost(url+"insertPolicelist");
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-Type", "application/json");
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("HTTPServer.content", request));
					
			try {
				httpPost.setEntity(new StringEntity(request, "UTF-8"));
				//接收返回数据
				client.execute(httpPost);
//				HttpEntity entity = response.getEntity();
//				result = EntityUtils.toString(entity,"UTF-8");			
				logger.info("发送给内网deallist数据为："+request);						
			}catch (IOException e) {
				e.printStackTrace();
			}
//			return result;
				
		}
		
		//查询公安处理完的数据
		public static String selectPolicelist(String request) throws Exception{	
			String result=null;		
			HttpClient client = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(20000).setConnectTimeout(20000).build();// 设置请求和传输超时时间
		
			HttpPost httpPost = new HttpPost(url+"selectPolicelist");
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-Type", "application/json");
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("HTTPServer.content", request));
					
			try {
				logger.info("开始发送查询deallist请求给内网");
				httpPost.setEntity(new StringEntity(request, "UTF-8"));
				//接收返回数据
				HttpResponse response = client.execute(httpPost);
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity,"UTF-8");			
				logger.info("获取查询deallist返回的结果为："+result);						
			}catch (IOException e) {
				e.printStackTrace();
			}
			return result;
				
		}		

	
}
