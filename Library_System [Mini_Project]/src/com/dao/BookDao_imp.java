package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.configuration.DBConnect;
import com.model.Book;

public class BookDao_imp implements BookDao {

	@Override
	public int addBook(Book b) {
		int status =0;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try
		{
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement("insert into book values (?,?,?,?,?)");
			preparedStatement.setInt(1, b.getBook_id());
			preparedStatement.setString(2, b.getBook_name());
			preparedStatement.setInt(3,b.getCatagory_id() );
			preparedStatement.setInt(4, b.getAuthor_id());
			preparedStatement.setInt(5,b.getPrice());
			
			status = preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			try {
				if(connection!=null)
					connection.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int removeBook(int book_id) {
		int status =0;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try
		{
			connection = DBConnect.getConnection();
			preparedStatement=connection.prepareStatement("delete from book where Book_id");
			preparedStatement.setInt(1, book_id);
			
			status =preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public int updatePrice(int book_id, int price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategary_id(String book_nm, int cate_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String search_bookby_name(String book_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search_bookby_author_id(int author_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search_bookby_category_id(int category_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
