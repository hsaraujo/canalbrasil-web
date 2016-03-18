package br.com.canalbrasil2.service;

import java.util.List;

import br.com.canalbrasil2.model.member.Member;

public interface MemberService 
{
	List<Member> getRank();
	
	Member getMember(String user, int pageNumber);
}
