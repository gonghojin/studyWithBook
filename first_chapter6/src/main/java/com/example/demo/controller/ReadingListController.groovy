package com.example.demo.controller

import com.example.demo.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class ReadingListController {

    @Autowired
    AmazonProperties amazonProperties

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(Reader reader, Model model) {
        List<Book> readingList = Book.findAllByReader(reader) // 그루비와 자바의 큰 차이 중 하나 : repository 주입이 없어짐
        model.addAttribute("reader", reader)
        if (readingList) {
            model.addAttribute("books", readingList)
            model.addAttribute("amzonId", amazonProperties.getAssociateId())
        }
        "readingList"
    }

    @RequestMapping(method = RequestMethod.POST)
    def addToReadingList(Reader reader, Book boo) {
        Book.withTransaction {
            book.setReader(reader)
            book.save()
        }
        "redirect:/"
    }
}
