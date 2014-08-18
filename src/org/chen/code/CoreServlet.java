package org.chen.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chen.code.dao.ProblemDao;
import org.chen.code.service.CoreService;
import org.chen.code.util.SignUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 核心servlet，用于处理来自微信服务器的消息。
 * @author 中普
 * @version 1.1
 *
 */
public class CoreServlet extends HttpServlet {

	
	private static final long serialVersionUID = 5485301464739619661L;
	
	
	/**
	 * get请求
	 * 确认请求来自微信服务器
	 * @see SignUtil
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String enchostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		
		// 如果完成check则回送
		if(SignUtil.checkSignature(signature, timestamp, nonce))
		{
			out.print(enchostr);
		}
		
		out.close();
		out = null;
	}

	/** 
	 * post请求
     * 处理微信服务器发来的消息 
     * @see CoreService
     */  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 将请求、响应的编码设置UFT-8，防止中文乱码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 加载数据源的xml
		ApplicationContext context =
				new ClassPathXmlApplicationContext("coder-datasource.xml");
		
		CoreService coreService = new CoreService();
		coreService.setProblemDao((ProblemDao) context.getBean("problemDao"));
		// 调用核心业务类接收消息、处理消息  
        String respMessage =coreService.processRequest(req); 
		
		PrintWriter out = resp.getWriter();
		out.print(respMessage);
		out.close();
	}

	
	
	
	
}
