package org.chen.code.message.resp;
/**
 * 回复图文的article
 * @author 中普
 * @version 1.0
 *
 */
public class Article {

	// 图文消息的名称
	private String Title;
	// 图文消息的描述
	private String Description;
	// 图片链接,jpg或png。限制图片链接的域名需要与开发者填写的基本资料中的Url一致
	private String PicUrl;
	// 点击图文消息的跳转链接
	private String Url;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description == null ? "":Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl == null ? "":PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url == null ? "" : Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
