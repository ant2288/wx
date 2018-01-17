package cn.abble.wx.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 登陆服务
 * @author 张郡峰
 *
 */

import cn.abble.wx.entity.UserEntity;
import cn.abble.wx.entity.UserInfoEntity;
import cn.abble.wx.mapper.UserMapper;
@Service
public class LoginService {
	@Autowired
	UserMapper usermapper;
	/**
	 * 通过构造的url获取Session_key和 openid
	 * @param url
	 * @return map包含了Session_key和 openid
	 */
	public Map<String,String> getSessionKey(String url) {
		Map<String, String> map = null;
		try {
			URL u = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
			String s = null;
			StringBuffer sb = new StringBuffer();
			while((s = br.readLine()) != null) {
				sb.append(s);
			}
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(sb.toString());
			map = mapper.readValue(sb.toString(), Map.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 通过openid获取用户实体
	 * @param openid
	 * @return 一个用户实体
	 */
	public UserEntity getUserByOpenid(String openid) {
		return usermapper.getUserByOpenid(openid);
	}
	
	/**
	 * 插入数据
	 */
	public void insertUser(String openid) {
		UserEntity u = new UserEntity();
		u.setOpenid(openid);
		usermapper.insertUser(u);
	}
	
	
	/**
	 * 更新用户头像与昵称
	 */
	public void updateAvatarUrlAndNickName(UserEntity u) {
		usermapper.updateAvatarUrlAndNickName(u);
	}
}
