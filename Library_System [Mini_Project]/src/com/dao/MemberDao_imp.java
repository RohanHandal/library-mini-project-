package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.configuration.DBConnect;
import com.model.Member;

public class MemberDao_imp implements MemberDao {

	@Override
	public int addmember(Member m) {
		int status =0;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try
		{
			connection = DBConnect.getConnection();
			preparedStatement =connection.prepareStatement(("insert into member values (?,?,?,?)"));
			preparedStatement.setInt(1, m.getMember_id());
			preparedStatement.setString(2, m.getMember_name());
			preparedStatement.setLong(3, m.getMobile());
			preparedStatement.setString(4, m.getAddress());
			
			status = preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		finally {
			try {
				if(preparedStatement!=null)
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int removemember(String Member_name) {
		int status =0;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try
		{
			connection = DBConnect.getConnection();
			preparedStatement =connection.prepareStatement("delete from member where Member_name =?");
			preparedStatement.setString(1, Member_name);
			status =preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}

	

	@Override
	public int updatemember_byname(String membername,String addr) {
		int status =0;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		String sql ="update Member set address=? where member_name=?";
		try
		{
		 preparedStatement = DBConnect.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, addr);
			preparedStatement.setString(2, membername);
			status =preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
}
