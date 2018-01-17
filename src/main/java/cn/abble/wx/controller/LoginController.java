package cn.abble.wx.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.abble.wx.entity.UserEntity;
import cn.abble.wx.entity.UserInfoEntity;
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
		System.out.println("开始注册用户数据");
		System.out.println("参数Code="+code);
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
		//获取openid和session_key
		Map<String,String> map = loginService.getSessionKey(url);
		
		UserEntity u = loginService.getUserByOpenid(map.get("openid"));
		if(u == null) {
			//如果没有插入数据
			loginService.insertUser(map.get("openid"));
		}
		System.out.println("注册成功，返回用户openid（主键）");
		return "{\"msg\":\""+map.get("openid")+"\"}";
	}
	
	@RequestMapping(value="/sendUserInfo",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String sendUsersInfo( @RequestBody Map<String,Object> map) throws Exception {
		System.out.println("开始更新用户头像、昵称、性别");
		String openid = (String) map.get("openid");
		Map<String,Object> userInfo = (Map<String, Object>) map.get("userInfo");
		String nickName = (String)userInfo.get("nickName");
		String avatarUrl = (String)userInfo.get("avatarUrl");
		int gender = (int)userInfo.get("gender");
		UserEntity user = new UserEntity();
		user.setOpenid(openid);
		user.setNickName(nickName);
		user.setAvatarUrl(avatarUrl);
		System.out.println(gender+" gender");
		user.setSex(gender == 1 ? "m" : "f");
		loginService.updateAvatarUrlAndNickName(user);
		//System.out.println(nickName+"   "+avatarUrl+"   "+gender);
		System.out.println("登陆流程结束");
		return  "";
	}
}
