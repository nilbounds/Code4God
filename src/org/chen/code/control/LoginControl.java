package org.chen.code.control;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.chen.code.bean.Admin;
import org.chen.code.dao.AdminDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录逻辑的控制器
 * @author 中普
 * @version 1.0
 * @see AdminDao
 *
 */
@Controller
public class LoginControl {

	@Inject
	@Named("adminDao")
	AdminDao adminDao;
	
	/**
	 * 登录的控制器核心事件
	 * @param admin 前端的管理员javabean
	 * @param req Http请求
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String toLogin(Admin admin,HttpServletRequest req)
	{
		req.getSession().setAttribute("validLogin", false);
		if(adminDao.hasAdmin(admin.getEmail()))
		{
			Admin admin2 = adminDao.getAdminByEmail(admin.getEmail());
			if(admin2.getPwd().equals(admin.getPwd()))
			{
				req.getSession().setAttribute("validLogin", true);
				req.getSession().setAttribute("admin", admin2);
				
			}
				
		}
		return "redirect:home";
	}
}
