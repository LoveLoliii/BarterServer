package com.ss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ss.dao.MobileUserDao;
import com.ss.model.User;
@Repository
public class MobileUserDaoImpl implements MobileUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> queryByParameters(Map<String, String> m) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from usert where ";
		if(!m.isEmpty()){
			Set<String> keySet = m.keySet();
			List<String> valueList = new ArrayList<String>();
			for(String key :keySet){
				sql+=key+"=? and " ;
				valueList.add(m.get(key));
				}
			int l = m.size();
			sql = sql.substring(0,sql.length()-4);
			System.out.println(sql);
			DataSource ds =  jdbcTemplate.getDataSource();
			try {
				Connection c = ds.getConnection();
				PreparedStatement pstm = c.prepareStatement(sql);
				for(int i=0;i<l;i++){
					pstm.setString(i+1, valueList.get(i));
				}
				
				ResultSet rs = pstm.executeQuery();
				System.out.println(rs);
				while(rs.next()){
					User u = new User();
					u.setName(rs.getString("name"));
					u.setPassword(rs.getString("password"));
					u.setPhone(rs.getString("phone"));
					u.setAddress(rs.getString("address"));
					u.setId(rs.getInt("id"));
					userList.add(u);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return userList;
		
	}

	@Override
	public User queryById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	 

}
