package cn.abble.wx.entity;
/**
 * 用户实体类
 * @author 张郡峰
 *
 */
public class UserEntity {
	private String openid;//用户唯一标识，主键
	private String avatarUrl;//头像url
	private String tel;//电话号码
	private String gender;//性别
	private String addr;//地址
	private String nickName;//昵称
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		return gender;
	}
	public void setSex(String gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
