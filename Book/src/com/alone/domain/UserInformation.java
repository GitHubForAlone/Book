package com.alone.domain;

import com.alone.util.Md5Encod;

public class UserInformation {
	public UserInformation() {}
	//用户ID
	private String id;
	//用户名
	private String name;
	//用户密码
	private String password;
	//用户电话
	private String tel;
	//用户身份证
	private String cardId;
	//用户注册日期
	private String registerDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Md5Encod.getMD5(password);
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
