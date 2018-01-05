package cn.abble.wx.sql;

import org.apache.ibatis.jdbc.SQL;

import cn.abble.wx.entity.UserEntity;
/**
 * User表的动态SQL语句生存
 * @author 张郡峰
 *
 */
public class UserSQL {
	public String getUserByOpenid(final String openid) {
		return new SQL() {
			{
				SELECT("*");
				FROM("users");
				WHERE("openid='"+openid+"'");
			}
		}.toString();
	}
	
	public String insertUser(UserEntity userEntity) {
		return new SQL() {
			{
				INSERT_INTO("users");
				VALUES("openid", "#{openid}");
			}
		}.toString();
	}
}
