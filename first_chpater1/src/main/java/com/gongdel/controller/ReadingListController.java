package com.gongdel.controller;

import com.gongdel.domain.Book;
import com.gongdel.domain.Reader;
import com.gongdel.repository.ReadingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ReadingListController {

    private ReadingListRepository readingListRepository;

   /* @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }
*/

    @GetMapping
    public String readerBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }

        return "readingList";
    }
    @PostMapping
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);

        return "redirect:/";
    }
}
