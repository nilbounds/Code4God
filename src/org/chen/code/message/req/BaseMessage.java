package org.chen.code.message.req;
/**
 * 请求消息的基类（user->公共账号)
 * @author 中普
 * @version 1.0
 *
 */
public class BaseMessage {

	// 开发者微信号
	private String ToUserName;
	// 发送账号,一个OPenID
    private String FromUserName;
    // 消息创建时间
    private long CreateTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息id，64位整数
    private long MsgId;
    
    /**
     * 获取开发者微信号
     * @return 开发者微信号
     */
	public String getToUserName() {
		return ToUserName;
	}
	/**
	 * 设置开发者微信号
	 * @param 开发者微信号
	 */
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	/**
	 * 获取发送账号,一个OPenID
	 * @return  发送账号
	 */
	public String getFromUserName() {
		return FromUserName;
	}
	/**
	 * 设置发送账号,一个OPenID
	 * @param 发送账号
	 */
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	/**
	 * 获取消息创建时间
	 * @return 消息创建时间
	 */
	public long getCreateTime() {
		return CreateTime;
	}
	/**
	 * 设置消息创建时间
	 * @param 消息创建时间
	 */
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	/**
	 * 获取消息类型
	 * @return text/image/location/link等
	 */
	public String getMsgType() {
		return MsgType;
	}
	/**
	 * 设置消息类型
	 * @param 消息类型
	 */
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	/**
	 * 获取消息id
	 * @return 消息id
	 */
	public long getMsgId() {
		return MsgId;
	}
	/**
	 * 设置消息id
	 * @param 消息id
	 */
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
    
	
    
    
}
