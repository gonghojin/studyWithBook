package com.example.gongdel.jupiter;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @DisplayName("세번째")
    @Test
    @Order(3)
    void 세번째_테스트() {
        System.out.println("세번째_테스트");
    }

    @DisplayName("두번째")
    @Test
    @Order(2)
    void 두번째_테스트() {
        System.out.println("두번째_테스트");
    }

    @DisplayName("첫번째")
    @Test
    @Order(1)
    void 첫번째_테스트() {
        System.out.println("첫번째_테스트");
    }
}