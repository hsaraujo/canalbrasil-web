package br.com.canalbrasil2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.canalbrasil2.model.member.Member;
import br.com.canalbrasil2.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController 
{
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/rank", method = RequestMethod.GET)
	public List<Member> getRank()
	{	
		return memberService.getRank(); 		
	}
	
	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	public Member getMember(@PathVariable(value="user") String user)
	{	
		return memberService.getMember(user);
	}
}
