package com.controller;

import java.util.Scanner;

import com.dao.BookDao_imp;
import com.dao.Book_registerDao_imp;
import com.dao.MemberDao_imp;
import com.model.Book;
import com.model.Member;

public class MainEntry {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("which operation u want to perform ???");
	System.out.println("1. add Book ,2.Remove book , 3. Upadate catagory ,4.Calculate fine ,5. ADD member , 6. Remove Member");
	int choice =sc.nextInt();
	int status =0;
	BookDao_imp bookDao_imp = new BookDao_imp();
	MemberDao_imp memberDao_imp = new MemberDao_imp();
	Book_registerDao_imp book_registerDao_imp = new Book_registerDao_imp();
	switch (choice)
	{
	case 1:
		    status =0;
			System.out.println("enter book details ");
			System.out.println("enter book id ");
			int bookId = sc.nextInt();
			System.out.println("enter book name ");
			String bookName =sc.next();
			System.out.println("category id ");
		    int  categoryId =sc.nextInt();
			System.out.println("enter price ");
			int price=sc.nextInt();
			System.out.println("author id");
			int authorId=sc.nextInt();
			Book b= new Book(bookId,bookName,categoryId,price,authorId);
			status = bookDao_imp.addBook(b);
			if(status >0)
			{
				System.out.println("book added sucssesfully");
				
			}
			else {
				System.out.println("unable to add record ");
			}
		break;
		
	case 2:
		status =0;
		System.out.println("enter book id to delete ");
		int deleteId=sc.nextInt();
		status = bookDao_imp.removeBook(deleteId);
		if(status >0)
		{
			System.out.println("book  remove sucssesfully");
			
		}
		else {
			System.out.println("unable to remove record ");
		}
	break;
	
	case 5 :
		status =0;
	System.out.println("enter Member details ");
	System.out.println("enter member id ");
	int member_id = sc.nextInt();
	System.out.println("enter member  name ");
	String member_name =sc.next();
	System.out.println("Mobile no ");
    long mobile   =sc.nextLong();
	System.out.println("Address ");
	String  address=sc.next();
	//System.out.println("author id");
//	int authorId=sc.nextInt();
	Member  m= new Member(member_id,member_name,mobile,address);
	status = memberDao_imp.addmember(m);
	if(status >0)
	{
		System.out.println("book added sucssesfully");
		
	}
	else {
		System.out.println("unable to add record ");
	}
break;

	case 6:
		status =0;
	System.out.println("enter member id to delete ");
	String Member_name=sc.next();
	status = memberDao_imp.removemember(Member_name);
	if(status >0)
	{
		System.out.println("book  remove sucssesfully");
		
	}
	else {
		System.out.println("unable to remove record ");
	}
break;
	case 4:
		status =0;
	System.out.println("enter member id to delete ");
	int fine=sc.nextInt();
	status = book_registerDao_imp.calulatefine(fine);
	if(status >0)
	{
		System.out.println("book  remove sucssesfully");
		
	}
	else {
		System.out.println("unable to remove record ");
	}
break;
		
	
	}	
}
}
