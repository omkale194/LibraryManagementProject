package com.mini.LibraryManagementProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mini.LibraryManagementProject.Entities.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, String> {
List<Books> findByGenre(String genre);
Books findByBookid(String bookid);
@Procedure(value="count_books")
int countBooks();

}
