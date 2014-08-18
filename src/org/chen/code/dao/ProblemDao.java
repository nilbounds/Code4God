package org.chen.code.dao;


import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import org.apache.naming.java.javaURLContextFactory;
import org.chen.code.bean.Problem;
import org.chen.code.util.CodeConstans;
import org.chen.code.util.DateUtil;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 问题problem对应的Dao
 * @author 中普
 * @version 1.1
 * @see Problem
 * @see JdbcDaoSupport
 *
 */
public class ProblemDao extends JdbcDaoSupport{

	private static String ADD_P =
			"insert into problems (create_date,title,content,answer,file_c,file_j) " +
			"values(?,?,?,?,?,?)";
	
	
	private final static String FIND_PROBLEM =
			"select title,content,answer from problems where id=?";
	
	
	private final static String FIND_ANSWER =
			"select answer from problems where id = ?";
	
	private final static String COUNT_PROBLEM =
			"select count(*) from problems where id < ?";
	
	
	private final static String DOWNLOAD =
			"select title,file_c,file_j from problems where id between ? and ?";
	/**
	 * 添加题目
	 * @param problem 问题 javabean
	 */
	public void addP(Problem problem)
	{
		
		java.sql.Date sd = new java.sql.Date(new Date().getTime());
		getJdbcTemplate().update(ADD_P,
				sd,
				problem.getTitle(),
				problem.getContent(),
				problem.getSolution(),
				problem.getC_file(),
				problem.getJ_file());
	}
	
	/**
	 * 通过问题的id获取题目
	 * @param id 问题的id
	 * @return
	 */
	public Problem getProblemById(int id)
	{
		return getJdbcTemplate().queryForObject(FIND_PROBLEM,
				new ParameterizedRowMapper<Problem>(){

					@Override
					public Problem mapRow(ResultSet arg0, int arg1)
							throws SQLException {
						Problem problem = new Problem();
						problem.setTitle(arg0.getString("title"));
						problem.setContent(arg0.getString("content"));
						problem.setSolution(arg0.getString("answer"));
						return problem;
					}
			
		},
		id);
	}
	
	/**
	 * 根据时间获取题目（含答案)
	 * @return Problem 文件javabean
	 * @throws ParseException
	 */
	public Problem getProblemByDate() throws ParseException
	{
		return getProblemById(DateUtil.getProblemId());
	}
	
	/**
	 * 通过问题的id获取答案分析
	 * @param id 问题的id
	 * @return 答案
	 */
	public String getAnswerById(int id)
	{
		return getJdbcTemplate().queryForObject(FIND_ANSWER,
				new ParameterizedRowMapper<String>(){

					@Override
					public String mapRow(ResultSet arg0, int arg1)
							throws SQLException {
						String string = arg0.getString("answer");
						
						return string;
					}
			
		},
		id);
	}
	
	/**
	 * 根据时间获取答案
	 * @return 答案
	 * @throws ParseException
	 */
	public String getAnswerByDate() throws ParseException
	{
		return getAnswerById(DateUtil.getProblemId());
	}
	
	/**
	 * 不是获取题目总数，而是获取今天及之前的题目总数
	 * @return 题目总数
	 * @throws ParseException 
	 */
	public int getCount() throws ParseException
	{
		//return getJdbcTemplate().queryForInt(COUNT_PROBLEM);
		
		return DateUtil.getProblemId() - CodeConstans.START_ID + 1;
	}
	
	
	/**
	 * 从start获取20个文件信息
	 * @param start 开始页码
	 * @return List<Problem>  问题list
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Problem> getFileByStart(int start) throws ParseException
	{
		int index = start + CodeConstans.START_ID - 1;
		int end = (int) (index + CodeConstans.PAGECOUNT);
		if(end > getCount() + CodeConstans.START_ID - 1)
			 end = getCount() + CodeConstans.START_ID - 1;
		
		return  getJdbcTemplate().query(DOWNLOAD, 
				new Object[]{index,end}
				, new int[]{java.sql.Types.INTEGER,java.sql.Types.INTEGER}, 
				new RowMapper() {

					@Override
					public Object mapRow(ResultSet arg0, int arg1)
							throws SQLException {
						Problem problem = new Problem();
						problem.setTitle(arg0.getString("title"));
						problem.setC_file(arg0.getString("file_c"));
						problem.setJ_file(arg0.getString("file_j"));
						return problem;
					}
				});
		
	}
}
