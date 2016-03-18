package br.com.canalbrasil2.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.canalbrasil2.model.member.Member;
import br.com.canalbrasil2.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController 
{
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/rank", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Member> getRank()
	{	
		return memberService.getRank(); 		
	}
	
	@RequestMapping(value = "/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Member getMember(@PathVariable(value="user") String user, @RequestParam(value="page") Integer page)
	{	
		if(page == null || page < 1)
			page = 1;
		
		return memberService.getMember(user, page);
	}
}
