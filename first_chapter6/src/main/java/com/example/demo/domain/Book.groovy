package com.example.demo.domain

import grails.persistence.Entity

@Entity // grail은 접근제어자, getsetter등이 불필요
class Book {
    Reader reader
    String isbn
    String title
    String author
    String description
}

