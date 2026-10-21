package com.mini.LibraryManagementProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.LibraryManagementProject.Entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{
Staff findBystaffid(int staffid);
}
