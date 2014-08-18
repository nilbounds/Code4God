package org.chen.code.bean;

/**
 * 管理员的JavaBean<br/>
 * 待改进的地方:密码目前明文存储，必须再次加密
 * @author 中普
 * @version 1.0
 *
 */
public class Admin {

	private String name;
	private String email;
	private String pwd;
	
	/**
	 * 获取管理员的名字
	 * @return 管理员的名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置管理员的名字
	 * @param  管理员的名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取管理员的邮箱
	 * @return 管理员的邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置管理员的邮箱
	 * @param email 管理员的邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获得密码
	 * @return 密码
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 设置密码
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * 构造函数
	 * @param name
	 * @param email
	 * @param pwd
	 */
	public Admin(String name, String email, String pwd) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
	/**
	 * 默认的构造器
	 */
	public Admin() {
		
	}
	
	
}
