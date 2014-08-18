package org.chen.code.message.resp;
/**
 * 响应的文本消息,继承BaseMessage
 * @author 中普
 * @see BaseMessage
 *
 */
public class TextMessage extends BaseMessage {

	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	
	
	
}
