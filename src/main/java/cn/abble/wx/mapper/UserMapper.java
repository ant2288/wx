package cn.abble.wx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.abble.wx.entity.UserEntity;
import cn.abble.wx.entity.UserInfoEntity;
/**
 * UserMapper接口
 * @author 张郡峰
 *
 */
public interface UserMapper {
	@SelectProvider(type=cn.abble.wx.sql.UserSQL.class,
			method="getUserByOpenid")
	@Results({
		@Result(property = "openid" , column = "openid"),
		@Result(property = "avatarUrl" , column = "avatarUrl"),
		@Result(property = "tel" , column = "tel"),
		@Result(property = "gender" , column = "gender"),
		@Result(property = "addr" , column = "addr"),
		@Result(property = "nickName" , column = "nickName")
	})
	UserEntity getUserByOpenid(String openid);
	
	
	
	@InsertProvider(type=cn.abble.wx.sql.UserSQL.class,
			method="insertUser")
	void insertUser(UserEntity userEntity);
	
	@UpdateProvider(type=cn.abble.wx.sql.UserSQL.class,
			method="updateAvatarUrlAndNickName")
	void updateAvatarUrlAndNickName(UserEntity u);
}
