package model;

import java.util.List;

import dao.MembersDAO;

public class GetListLogic {
	public List<Member> execute() {
	 MembersDAO dao = new MembersDAO();
	 List<Member> memberList = dao.findAll();
	 return memberList;
	}
}
