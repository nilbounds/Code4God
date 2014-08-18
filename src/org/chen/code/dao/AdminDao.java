package org.chen.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.chen.code.bean.Admin;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 管理员所对应的Dao
 * @author 中普
 * @see JdbcTemplate
 * @see JdbcDaoSupport
 *
 */
public class AdminDao extends JdbcDaoSupport{

	private final static String INSERT_ADMIN =
			"insert into Admin (email,pwd,name) values (?,?,?)";
	
	private final static String FIND_ADMIN =
			"select * from Admin where email=?";
	
	/**
	 * 添加新的管理员
	 * @param admin
	 */
	public void addAdmin(Admin admin){
		
		getJdbcTemplate().update(INSERT_ADMIN,
				admin.getEmail(),
				admin.getPwd(),
				admin.getName());
	}
	
	/**
	 * 通过email找人
	 * @param email
	 * @return
	 */
	public Admin getAdminByEmail(final String email)
	{
		return getJdbcTemplate().queryForObject(FIND_ADMIN,
				new ParameterizedRowMapper<Admin>() {

					@Override
					public Admin mapRow(ResultSet arg0, int arg1)
							throws SQLException {
						Admin admin = new Admin();
						admin.setEmail(email);
						admin.setPwd(arg0.getString("pwd"));
						admin.setName(arg0.getString("name"));
						return admin;
					}
			        
				},
				email
				);
	}
	
	/**
	 * 是否有这个人
	 * @param email
	 * @param pwd
	 * @return
	 */
	public boolean hasAdmin(String email){
		
	
		try {
			if(getJdbcTemplate().queryForList(FIND_ADMIN, email).size() > 0)
			{
				return true;
			}
		} catch (Exception e) {
			
			return false;
		}
		
		return false;
		
	}
}
