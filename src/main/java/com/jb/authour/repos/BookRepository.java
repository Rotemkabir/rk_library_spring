package com.jb.authour.repos;

import com.jb.authour.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book>findByYearBetween(int start, int end);

    @Query(value = "select avg(year) from books", nativeQuery = true)
    double avgYearsAllBooks();

    @Query(value = "select avg(year) from books where author_id = ?", nativeQuery = true)
    double avgYearsAllBooksByAuthor(int id);


}
