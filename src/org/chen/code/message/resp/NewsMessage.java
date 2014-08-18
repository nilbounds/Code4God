package org.chen.code.message.resp;

import java.util.List;

/**
 * 图文消息 ,继承 BaseMessage
 * @author 中普
 * @version 1.0
 * @see BaseMessage
 * 
 *
 */
public class NewsMessage extends BaseMessage {

	// 图文消息个数，10以内
	private int ArticleCount;
	// 多条消息。默认第一条item为大图
	private List<Article> Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
	
	
	
}
