package com.mini.LibraryManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="delete_audit")
public class Delete_Book_Audit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookid;
    private String deletedat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	
	public String getDeletedat() {
		return deletedat;
	}
	public void setDeletedat(String deletedat) {
		this.deletedat = deletedat;
	}
    
    


}
