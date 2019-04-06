package com.example.gongdel.jupiter;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifecycleTest {

    // 모든 테스트 시작 전 한번 실행
    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll");
    }

    // 각각의 테스트 전 실행
    @BeforeEach
    void init() {
        System.out.println("@BeforeEach");
    }


    @Test
    void test1() {
        assertEquals(1, 1);
        System.out.println("test1");
    }

    @Test
    void test2() {
        assertEquals(2, 2);
        System.out.println("test2");
    }

    // 각각의 테스트 후 실행
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach");
    }

    // 모든 테스트 완료 후 한번 실행
    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll");
    }
}
