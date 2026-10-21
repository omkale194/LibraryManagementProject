package com.mini.LibraryManagementProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mini.LibraryManagementProject.Entities.Staff;
import com.mini.LibraryManagementProject.Repository.StaffRepository;

@Controller
public class StaffController {
@Autowired 
private StaffRepository strepo;


@GetMapping("allstaff")
public ModelAndView allStaff(Staff obj) {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("allStaffList.jsp");
	List<Staff> stlist=strepo.findAll();
    mv.addObject("stlist", stlist);
	return mv;
}
@GetMapping("addstaff")
public String addStaff() {
	return "addStaffForm.html";
}

@PostMapping("newstaff")
public String newStaff(Staff obj) {
	strepo.save(obj);
	return "doneAddStaff.jsp";
}

@GetMapping("updatestaffsal")
public String upstaff(){
	return "updateStaffSalForm.html";
}
@PostMapping("upstaffsal")
public String doneupsal(int staffid,float salary) {
    Staff staff = strepo.findBystaffid(staffid);
    
    if (staff != null) {
        staff.setSalary(salary);
        strepo.save(staff);
        return "DoneUpSal.jsp"; 
    } else {
        return "invalidstaffid.jsp"; 
    }
}
@GetMapping("deletestaff")
public String delStaff() {
	return "DeleteStaffForm.html";
}
@PostMapping("delstaff")
public String doneDelStaff(int staffid) {
Staff staff = strepo.findBystaffid(staffid);
    
    if (staff != null) {
        strepo.delete(staff);
        return "doneDeleteStaff.jsp"; 
    } else {
        return "cancelstaffid.jsp"; 
    }
}
}
