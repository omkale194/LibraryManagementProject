package com.mini.LibraryManagementProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mini.LibraryManagementProject.Entities.Members;
import com.mini.LibraryManagementProject.Repository.MemberRepository;

@Controller
public class MemberController {

	
	@Autowired
	private MemberRepository memrepo;
	@GetMapping("allmembers")
	public ModelAndView allmembers(Members obj) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Memberlist.jsp");
		List<Members> mlist=memrepo.findAll();
		mv.addObject("mlist",mlist);
		return mv;
		
	}
	
	@GetMapping("newmem")
	public String addmembers() {
		return "MembersForm.html";
	}
	@PostMapping("addmem")
	public String donemembers(Members obj) {
		memrepo.save(obj);
		return "DoneMembers.jsp";
	}
	
	@GetMapping("deletemem")
	public String delmem() {
		return "deleteMemberForm.html";
	}
	
	@PostMapping("DoneDeleteMem")
		public String donedeleteMem(String mid) {
			Members obj=memrepo.findByMid(mid);
			if(obj!=null) {
			Members id=memrepo.findByMid(mid);
			memrepo.delete(id);
			return "DoneDeleteMemebers.jsp";
			}
			else {
				
				return "cancelDeleteMember.jsp";
			}
			
		}
	}

