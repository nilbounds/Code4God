package org.chen.code.message.req;
/**
 * 请求的文本信息，继承BaseMessage
 * @author 中普
 * @version 1.0
 * @see BaseMessage
 *
 */
public class TextMessage extends BaseMessage {

	// 消息内容
	private String Content;

	/**
	 * 获取消息的内容
	 * @return 消息的内容
	 */ 
	public String getContent() {
		return Content;
	}

	/**
	 * 设置消息的内容
	 * @param 消息的内容
	 */
	public void setContent(String content) {
		Content = content;
	}

	
	
}
