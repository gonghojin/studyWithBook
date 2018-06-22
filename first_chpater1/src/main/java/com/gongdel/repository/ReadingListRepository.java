package com.gongdel.repository;


import com.gongdel.domain.Book;
import com.gongdel.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(Reader reader);
}
