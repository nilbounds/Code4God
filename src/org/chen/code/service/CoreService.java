package org.chen.code.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;


import org.chen.code.bean.Problem;
import org.chen.code.dao.ProblemDao;
import org.chen.code.message.resp.Article;
import org.chen.code.message.resp.NewsMessage;
import org.chen.code.message.resp.TextMessage;
import org.chen.code.util.CodeConstans;
import org.chen.code.util.DateUtil;
import org.chen.code.util.HandleXML;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 核心服务类
 * @author 中普
 * @version 2.0
 * @see ProblemDao
 *
 */

public class CoreService {

	
	ProblemDao problemDao;
	
	/**
	 * 获取ProblemDao
	 * @return ProblemDao
	 */
	public ProblemDao getProblemDao() {
		return problemDao;
	}


	/**
	 * 设置ProblemDao（此处没有使用自动注入)
	 * @param problemDao
	 */
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}


	/**
	 * 
	 * @param request Http请求
	 * @return 处理的结果
	 * @see HandleXML
	 */
	public String processRequest(HttpServletRequest request)
	{
	
		
		String respMessage = null;
		// 回复文本消息
		TextMessage textMessage = new TextMessage();
		try {
			// 默认返回
			String respContent = "请求处理异常,请稍后重试！";
			// xml 请求解析
			Map<String, String> requestMap = HandleXML.parseXml(request);
			
			// 发送方账号(open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公共账号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
		
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(HandleXML.RESP_MESSAGE_TEXT);
			textMessage.setFuncFlag(0);
			
			if(msgType.equals(HandleXML.REQ_MESSAGE_TEXT))
			{
				// 接受用户的文本信息内容
				String content = requestMap.get("Content");
				
				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(HandleXML.RESP_MESSAGE_NEWS);
				newsMessage.setFuncFlag(0);
				
				textMessage.setContent(respContent);
				respMessage = HandleXML.textMessageToXml(textMessage);
				
				List<Article> articles = new ArrayList<Article>();
				// 单图文消息
				if("1".equals(content))
				{
					
					Article article = new Article();
					
					Problem problem = problemDao.getProblemByDate();

					article.setTitle(problem.getTitle());
					article.setDescription(HandleXML.delHTML(problem.getContent()));
					article.setPicUrl("http://bcs.duapp.com/czpresource/Img/"+DateUtil.getProblemId()+".jpg");
					article.setUrl("");
					/*
					article.setTitle("测试标题");
					article.setDescription("描述文字，算法，算法，欢迎你的关注..");
					article.setPicUrl("http://codeforgod.duapp.com/resources/images/ati.jpg");
					article.setUrl("http://codeforgod.duapp.com/home");*/
					
					articles.add(article);
					
					newsMessage.setArticleCount(articles.size());
					newsMessage.setArticles(articles);
					
					respMessage = HandleXML.newsMessageToXML(newsMessage);
				}
				
				else if ("2".equals(content)) {
					
					Article article = new Article();
					article.setTitle("答案分析");
					article.setDescription(HandleXML.delHTML(problemDao.getAnswerByDate().substring(0, 50)));
					article.setPicUrl("http://bcs.duapp.com/czpresource/Img/"+DateUtil.getProblemId()+".jpg");
					article.setUrl("http://codeforgod.duapp.com/detail");
					
					articles.add(article);
					
					newsMessage.setArticleCount(articles.size());
					newsMessage.setArticles(articles);
					
					respMessage = HandleXML.newsMessageToXML(newsMessage);
				}
				
				else if("3".equals(content))
				{
					Article article = new Article();
					article.setTitle("昨日问题");
					int id = DateUtil.getProblemId() - 1;
					article.setDescription(CodeConstans.YESTERDAY);
					article.setPicUrl("http://bcs.duapp.com/czpresource/Img/"+id+".jpg");
					article.setUrl("http://codeforgod.duapp.com/history/1");
					
					articles.add(article);
					
					newsMessage.setArticleCount(articles.size());
					newsMessage.setArticles(articles);
					
					respMessage = HandleXML.newsMessageToXML(newsMessage);
				}
				else if("4".equals(content))
				{
					Article article = new Article();
					article.setTitle("前日问题");
					int id = DateUtil.getProblemId() - 2;
					article.setDescription(CodeConstans.QIANTIAN);
					article.setPicUrl("http://bcs.duapp.com/czpresource/Img/"+id+".jpg");
					article.setUrl("http://codeforgod.duapp.com/history/2");
					
					articles.add(article);
					
					newsMessage.setArticleCount(articles.size());
					newsMessage.setArticles(articles);
					
					respMessage = HandleXML.newsMessageToXML(newsMessage);
				}
				
				else if(content.startsWith("#code#"))
				{
					textMessage.setContent(CodeConstans.ADVICE);
					respMessage = HandleXML.textMessageToXml(textMessage);
				}
				else if(content.equals("100"))
				{
					textMessage.setContent("希望你幸福，Miss占。");
					respMessage = HandleXML.textMessageToXml(textMessage);
				}
				else {
					textMessage.setContent(CodeConstans.HELP);
					respMessage = HandleXML.textMessageToXml(textMessage);
				}
				
				
			}
			
			else if (msgType.equals(HandleXML.REQ_MESSAGE_TYPE_ENVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if(eventType.equals(HandleXML.EVENT_TYPE_SUBSCRIBE))
				{
					respContent = CodeConstans.WELCOME;
					textMessage.setContent(respContent);
					respMessage = HandleXML.textMessageToXml(textMessage);
				}
				// 取消订阅
				else if (eventType.equals(HandleXML.EVENT_TYPE_UNSUBSCRIBE)) {
					
				}
				// 自定义菜单暂不处理
				else if (eventType.equals(HandleXML.EVENT_TYPE_CLICK)) {
					
				}
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return respMessage;
	}
}
