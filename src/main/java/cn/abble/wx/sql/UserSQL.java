package cn.abble.wx.sql;

import org.apache.ibatis.jdbc.SQL;

import cn.abble.wx.entity.UserEntity;
import cn.abble.wx.entity.UserInfoEntity;
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
	
	public String insertUser(final UserEntity userEntity) {
		return new SQL() {
			{
				INSERT_INTO("users");
				VALUES("openid", "#{openid}");
			}
		}.toString();
	}
	
	public String updateAvatarUrlAndNickName(final UserEntity u) {
		return new SQL() {
			{
				UPDATE("users");
				SET("avatarUrl = #{avatarUrl}");
				SET("nickName = #{nickName}");
				SET("gender = #{gender}");
				WHERE("openid = #{openid}");
			}
		}.toString();
	}
}
