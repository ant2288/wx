package cn.abble.wx.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.abble.wx.entity.UserEntity;
import cn.abble.wx.service.LoginService;


@EnableAutoConfiguration
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	private static final String APPID = "wxbc00479b563dc538";
	private static final String SECRET = "eac9333a70829ae07b9e1ca0d3b2551e";
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestBody String code) {
		System.out.println(code);
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
		//获取openid和session_key
		Map<String,String> map = loginService.getSessionKey(url);
		
		UserEntity u = loginService.getUserByOpenid(map.get("openid"));
		if(u == null) {
			//如果没有插入数据
			loginService.insertUser(map.get("openid"));
		}
		return "{\"msg\":\""+map.get("openid")+"\"}";
	}
	
	@RequestMapping(value="/sendUserInfo",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String sendUsersInfo(@RequestBody String userInfo) {
		System.out.println(userInfo);
		System.out.println("end");
		return  "";
	}
}
