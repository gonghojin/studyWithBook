package com.gongdel.controlelr;

import com.gongdel.domain.Book;
import com.gongdel.repository.ReadingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final String reader = "gongdel";
    private ReadingListRepository readingListRepository;

   /* @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }
*/

    @GetMapping
    public String readerBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }

        return "readingList";
    }
    @PostMapping
    public String addToReadingList(Book book) {
        book.setReader(reader);
        readingListRepository.save(book);

        return "redirect:/";
    }
}
