package com.mini.LibraryManagementProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.LibraryManagementProject.Entities.Delete_Book_Audit;

@Repository
public interface Delete_Book_auditRepository extends JpaRepository<Delete_Book_Audit, Integer>{
Delete_Book_Audit findByBookid(String bookid);
}
