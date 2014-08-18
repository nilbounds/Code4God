package org.chen.code.control;


import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.chen.code.bean.Problem;
import org.chen.code.dao.ProblemDao;
import org.chen.code.util.CodeConstans;
import org.chen.code.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * 管理页面的控制器
 * @author 中普
 * @version 1.1
 * @see ProblemDao
 *
 */
@Controller
public class ManageControl {

	@Inject
	@Named("problemDao")
	ProblemDao problemDao;
	
	
	/**
	 * 进入管理页面
	 * @param req HTTP请求
	 * @return 逻辑视图 manage
	 * @throws ParseException
	 */
	@RequestMapping(value="/manage",method=RequestMethod.POST)
	public String toManage(HttpServletRequest req) throws ParseException{
		
		if(req.getSession().getAttribute("problem") == null)
		{
			Problem problem = problemDao.getProblemByDate();
			req.getSession().setAttribute("problem", problem.getContent());
		}
		
		return "manage";
	}
	
	/**
	 * 添加题目的控制器
	 * @param problem 问题
	 * @return 逻辑视图 manage
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String toAdd(Problem problem)
	{
	
		problemDao.addP(problem);
		problem = null;
		return "manage";
	}
	
	
	/**
	 * 查看今日问题的控制器
	 * @param req Http请求
	 * @return 逻辑视图 detail
	 * @throws ParseException
	 */
	@RequestMapping(value="/detail")
	public String toDetail(HttpServletRequest req) throws ParseException
	{
		if(req.getSession().getAttribute("TodayProblem") == null)
		{
			Problem problem = problemDao.getProblemByDate();
			req.getSession().setAttribute("TodayProblem",problem);
		}
		
		return "detail";
	}
	
	@RequestMapping(value="/more")
	public String toMore()
	{
		return "more";
	}
	
	/**
	 * 开始进入下载。
	 * @param req Http请求
	 * @return 逻辑视图 download
	 * @throws ParseException 
	 */
	@RequestMapping(value="/download/{toPage}")
	public ModelAndView toDownLoad(HttpServletRequest req,@PathVariable("toPage") int toPage) throws ParseException
	{
		
		
			List<Problem> problems = null;
			// 获取总的页数
			double count = problemDao.getCount() / CodeConstans.PAGECOUNT;
			int page = (int) Math.ceil(count);
			req.setAttribute("pages", page);
		
			req.setAttribute("currentPage", toPage);
			
			// 当前分页
			int start = (int) ((toPage - 1) * CodeConstans.PAGECOUNT + 1);
			problems = problemDao.getFileByStart(start);
			return new ModelAndView("download","files",problems);
			
	}
	
	/**
	 * beforeDay的意义是距离今天的天数，如1表示昨天，2表示前天,用于处理微信消息
	 * 把今日的id减去beforeDay就是对应历史记录的id
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/history/{beforeDay}")
	public ModelAndView toHistory(@PathVariable("beforeDay") int beforeDay) throws ParseException
	{
		
		int id = DateUtil.getProblemId() - beforeDay;
		Problem problem = problemDao.getProblemById(id);
		
		return new ModelAndView("history","historyProblem",problem);
	}
	
}
