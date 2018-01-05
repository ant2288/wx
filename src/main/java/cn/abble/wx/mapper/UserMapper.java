package cn.abble.wx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.abble.wx.entity.UserEntity;
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
		@Result(property = "headImg" , column = "headImg"),
		@Result(property = "tel" , column = "tel"),
		@Result(property = "sex" , column = "sex"),
		@Result(property = "addr" , column = "addr"),
		@Result(property = "nickName" , column = "nickName")
	})
	UserEntity getUserByOpenid(String openid);
	
	
	
	@InsertProvider(type=cn.abble.wx.sql.UserSQL.class,
			method="insertUser")
	void insertUser(UserEntity userEntity);
}
