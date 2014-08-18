package org.chen.code.control;

import java.text.ParseException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.chen.code.bean.Admin;
import org.chen.code.dao.AdminDao;
import org.chen.code.dao.ProblemDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 和主页相关的控制器
 * @author 中普
 * @version 1.1
 * @see AdminDao
 * @see ProblemDao
 *
 */
@Controller
public class HomeControl {

	@Inject
	@Named("adminDao")
	AdminDao adminDao;
	

	@Inject
	@Named("problemDao")
	ProblemDao problemDao;
	
	/**
	 * 进入主页home的处理逻辑
	 * @param req HttpServletRequest
	 * @return ModelAndView模型视图
	 * @throws ParseException
	 */
	@RequestMapping("/home")
	public ModelAndView showHomePage(HttpServletRequest req) throws ParseException
	{
		if(req.getSession().getAttribute("TodayTitle") == null)
		{
			// 在session里存储今日问题的标题
			String title = problemDao.getProblemByDate().getTitle();
			req.setAttribute("TodayTitle", title);
		}
			
		return new ModelAndView("home");
	}
	
	/**
	 * 404 not found的处理逻辑
	 * @return
	 */
	@RequestMapping("/404")
	public String to404()
	{
		return "404";
	}
	
	
}
