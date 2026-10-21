package com.mini.LibraryManagementProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.LibraryManagementProject.Entities.Books_audit;

@Repository
public interface Book_auditRepository extends JpaRepository<Books_audit, Integer> {

}
