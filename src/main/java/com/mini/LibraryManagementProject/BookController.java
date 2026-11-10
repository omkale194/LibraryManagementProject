package com.mini.LibraryManagementProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mini.LibraryManagementProject.Entities.Books;
import com.mini.LibraryManagementProject.Entities.Books_audit;
import com.mini.LibraryManagementProject.Entities.Delete_Book_Audit;
import com.mini.LibraryManagementProject.Repository.BookRepository;
import com.mini.LibraryManagementProject.Repository.Book_auditRepository;
import com.mini.LibraryManagementProject.Repository.Delete_Book_auditRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepo; 
	@Autowired
	private Book_auditRepository bookaurepo;
	@Autowired
	private Delete_Book_auditRepository delbookrepo;

	// Replaces the old MySQL triggers (not allowed on Clever Cloud free plan).
	// Same format as MySQL NOW(), but in Indian time.
	private static String nowIst() {
		return java.time.LocalDateTime.now(java.time.ZoneId.of("Asia/Kolkata"))
				.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	
	@GetMapping("/")
	public String mainPage(HttpSession ses) {
		ses.invalidate();
		return "adminPage.html";
	}
	
	@PostMapping("adminlogin")
	public String bookHome(String userid,String password ,HttpSession ses) {
		if("admin".equals(userid) && "admin@123".equals(password)) {
			ses.setAttribute("userid", userid);
			return "main.jsp";
		}
		else {
			ses.invalidate();
			return "invalidadmin.jsp";
		}
		
	}
	@GetMapping("/admin")
	public String Homepage(HttpSession ses) {
		if(ses.getAttribute("userid")!=null) {
		return "main.jsp";
		}
		else{
			ses.invalidate();
			return "invalidadmin.jsp";
		}
	}
	
    @GetMapping("/adbook")
    public String bookForm() {
    	return "addbookform.html";
    }
    
    @Transactional
    @PostMapping("/newbook")
    public String newBook(Books obj) {
    	 
    	if (bookRepo.findById(obj.getBookid()).isPresent()) {
            System.out.println("Book with ID " + obj.getBookid() + " already exists.");
            return "errorBookExists.jsp";  
        }

        bookRepo.save(obj);

        // replaces trigger books_after_insert
        Books_audit audit = new Books_audit();
        audit.setBookid(obj.getBookid());
        audit.setTitle(obj.getTitle());
        audit.setAuthor(obj.getAuthor());
        audit.setAddedAt(nowIst());
        bookaurepo.save(audit);

        return "doneNewBook.jsp";
    }
    @GetMapping("allbook")
    public ModelAndView allBook(Books obj) {
    	
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("allBooklist.jsp");
    	List<Books> blist=bookRepo.findAll();
    	int clist=bookRepo.countBooks();
    	mv.addObject("booklist",blist);
    	mv.addObject("count",clist);
    	System.out.println("No of books retrived"+blist.size());
    	return mv;
    }
    @GetMapping("searchbygen")
    public String searchByGen() {
    	return "SearchByGenre.html";
    }
    
    @PostMapping("findgenre")
    public ModelAndView findGenre(String genre,HttpSession ses) {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("DoneSearchGenre.jsp");
    	List<Books> genlist=bookRepo.findByGenre(genre);
    	ses.setAttribute("genre", genre);
    	mv.addObject("glist",genlist);
    	return mv;
    }
      
    @GetMapping("isbnno")
    public String searchIsbn() {
    	return "SearchISBNno.html";
    }
    @PostMapping("findisbn")
    public ModelAndView retriveisbn(String bookid,HttpSession ses) {
    	Books obj=bookRepo.findByBookid(bookid);
    	if(obj!=null) {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("DoneIsbn.jsp");
    	Books isbno=bookRepo.findByBookid(bookid);
    	mv.addObject("isbno",isbno);
    	ses.setAttribute("bookid", bookid);
    	return mv;
    	}
    	else {
    		ModelAndView mv=new ModelAndView();
        	mv.setViewName("failReturn.jsp");
        	return mv;
    	}
    	
    }
    
    @GetMapping("delbook")
    public String deleteForm() {
    	return "DeleteForm.html";
    }
    @Transactional
    @PostMapping("DoneDelete")
    public String DoneDeletePage(String bookid)
    {
    	Books delbook=bookRepo.findByBookid(bookid);
    	if(delbook!=null) {
        bookRepo.delete(delbook);
    	// replaces trigger books_after_delete
    	Delete_Book_Audit delAudit = new Delete_Book_Audit();
    	delAudit.setBookid(delbook.getBookid());
    	delAudit.setDeletedat(nowIst());
    	delbookrepo.save(delAudit);
    	return "DoneDelete.jsp";
    	}
    	else {
    		return "failReturn.jsp";
    	}
    	}
    @GetMapping("upprice")
    public String uppriceForm() {
    	return "UpdatePriceForm.html";
    }
    @PostMapping("updateprice")
    public String doneUpdatePrice(String bookid ,float price ) {
    	Books obj=bookRepo.findByBookid(bookid);
    	if(obj!=null) {
    	obj.setPrice(price);
    	obj=bookRepo.save(obj);
    	return "DoneUpdatePrice.jsp";
    	}
    	else {
    		return "failReturn.jsp";
    	}
    }
    //Book_audit table
    @GetMapping("addrecord")
    public ModelAndView adbookaudit(Books_audit obj) {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("auditBookrecord.jsp");
    	List<Books_audit> audit =bookaurepo.findAll();
    	mv.addObject("audit",audit);
    	return mv;
    
     }
    @GetMapping("delrecord")
    public ModelAndView delBookAudit(Delete_Book_Audit obj) {
    	 ModelAndView mv=new ModelAndView();
       	 mv.setViewName("deleteRecord.jsp");
       	 List<Delete_Book_Audit> dlist=delbookrepo.findAll();
       	 mv.addObject("dlist",dlist);
         return mv;
    }
    @GetMapping("searchid")
    public ModelAndView searchById(String bookid) {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("DoneSearchID.jsp");
    	Books id=bookRepo.findByBookid(bookid);
    	mv.addObject("id",id);
    	return mv;
    }
    @GetMapping("/erdiagram")
	public String erPage() {
		return "erDiagram.html";
	}
	
	@GetMapping("/moreinfo")
	public String aboutUS() {
		return "aboutUS.html";
	}
	
  
    
}