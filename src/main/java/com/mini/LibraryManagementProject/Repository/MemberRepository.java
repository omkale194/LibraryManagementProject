package com.mini.LibraryManagementProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.LibraryManagementProject.Entities.Members;

@Repository
public interface MemberRepository extends JpaRepository<Members, String>  {
Members findByMid(String mid);
}
