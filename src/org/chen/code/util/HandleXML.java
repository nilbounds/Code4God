package org.chen.code.util;


import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.chen.code.message.resp.Article;
import org.chen.code.message.resp.NewsMessage;
import org.chen.code.message.resp.TextMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.SortableFieldKeySorter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 解析XML
 * @author 中普
 * @see SAXReader
 * @see Document
 * @see Element
 * @see XStream
 *
 */
public class HandleXML {
	
	/**
	 * 返回消息类型，文本
	 */
	public static final String RESP_MESSAGE_TEXT = "text";
	
	public static final String RESP_MESSAGE_NEWS = "news";

	/**
	 * 请求消息类型
	 */
	public static final String REQ_MESSAGE_TEXT = "text";
	
	/**
	 * 请求消息类型，推送
	 */
	public static final String REQ_MESSAGE_TYPE_ENVENT = "event";
	
	/**
	 * 事件类型：订阅
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	
	/**
	 * 事件类型：取消订阅
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubcribe";
	
	
	/**
	 * 消息类型：点击自定义菜单
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	
	
	/**
	 * 解析微信请求的xml格式消息<br/>
	 * 从request中得到微信服务器发送给我们的xml格式的消息
	 * @param request
	 * @return 存储消息的键值对
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest request)
	 throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		
		InputStream inputStream = request.getInputStream();
		
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 根节点
		Element root = document.getRootElement();
		
		// 得到所有的子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		
		for(Element element :elementList)
		{
			map.put(element.getName(), element.getText());
		}
		
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	
	/**
	 * 文本消息对象转换成xml【采用开源框架xstream来实现Java类到xml的转换】
	 */
	public static String textMessageToXml(TextMessage textMessage)
	{
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 图片消息对象转成xml
	 * @param newsMessage
	 * @return 图片消息的xml格式
	 */
	public static String newsMessageToXML(NewsMessage newsMessage)
	{
		xstream.alias("xml", newsMessage.getClass());  
	    xstream.alias("item", new Article().getClass());  
	    return xstream.toXML(newsMessage);  
	}
	
	
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                    writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	});  
	
	
	/**
	 * 用于清除字符串中HTML的元素
	 * @param source 原始字符串
	 * @return 清除后的字符串
	 */
	public static String delHTML(String source)
	{
		String regEx_html = "<[^>]+>";
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(source);
		source = m_html.replaceAll("");
		
		String result = source.replace("&nbsp;", " ");
		result = result.replace("&lt;", "<");
		result = result.replace("&gt;", ">");
		return result;
	}
}
