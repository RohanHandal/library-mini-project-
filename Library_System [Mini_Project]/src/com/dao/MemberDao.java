package com.dao;

import java.util.List;

import com.model.Member;

public interface MemberDao {

	int addmember(Member m);
	int removemember(String Member_name);
	int updatemember_byname(String Member_name,String address);
}
