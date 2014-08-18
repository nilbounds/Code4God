package org.chen.code.bean;

import java.util.Date;
/**
 * 问题Problem的JavaBean
 * @author 中普
 * @version 1.0
 *
 */
public class Problem {

	private Date create;
	private String title;
	private String content;
	private String solution;
	private String c_file;
	private String j_file;
	/**
	 * 获取问题的标题
	 * @return 题目标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置问题的标题
	 * @param 题目标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取问题的正文
	 * @return 问题的正文
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置问题的正文
	 * @param 问题的正文
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取问题的分析
	 * @return 问题的分析
	 */
	public String getSolution() {
		return solution;
	}
	/**
	 * 设置问题的分析
	 * @param 问题的分析
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}
	/**
	 * 获取问题的Cpp解决方法的文件路径(百度存储)
	 * @return Cpp解决方法的文件路径
	 */
	public String getC_file() {
		return c_file;
	}
	/**
	 * 设置问题的Cpp解决方法的文件路径(百度存储)<br/>
	 * 如果参数为null，则设置为""
	 * @param Cpp解决方法的文件路径
	 */
	public void setC_file(String c_file) {
		this.c_file = c_file == null ? "":c_file;
	}

	/**
	 * 获取问题的Java解决方法的文件路径(百度存储)
	 * @return Java解决方法的文件路径
	 */
	public String getJ_file() {
		return j_file;
	}
	/**
	 * 设置问题的Java解决方法的文件路径(百度存储) <br/>
	 * 如果参数为null，则设置为""
	 * @param Java解决方法的文件路径
	 */
	public void setJ_file(String j_file) {
		this.j_file = j_file == null ? "":j_file;
	}
	/**
	 * 获取问题创建时间
	 * @return 问题创建时间
	 */
	public Date getCreate() {
		return create;
	}
	/**
	 * 设置问题创建时间
	 * @param create
	 */
	public void setCreate(Date create) {
		this.create = create;
	}

	
	
	
}
