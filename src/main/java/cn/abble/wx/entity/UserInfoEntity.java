package cn.abble.wx.entity;

/**
 * 用户信息实体类
 * @author 12482
 *
 */
public class UserInfoEntity {
	private String nickName;
	private String avatarUrl;
	private int gender;
	
	public UserInfoEntity(String nickName, String avatarUrl, int gender) {
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.gender = gender;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	
}
