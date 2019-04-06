package com.example.gongdel.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    Person person = new Person("hojin", "gong");

    @Test
    @DisplayName("assertEquals(예상값, 실제값, '비교에 대한 설명')")
    void test1() {
        assertEquals(2, 2, "2와 2의 비교는 같드");
    }

    @Test
    @DisplayName("assertAll('테스트 내용', 람다...)")
    void test2() {
        assertAll("성, 이름 테스트",
                () -> assertEquals(person.firstName, "hojin"),
                () -> assertEquals(person.lastName, "gong")
        );
    }

    @Test
    @DisplayName("에러 처리 테스트")
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int a = 1;
            int b = 0;
            int c = a / b;
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("타임아웃 테스트")
    void timeoutNotExceeded_테스트() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            //  Thread.sleep(2000);
            System.out.println("2초 안에 돌면 성공");
        });
    }

    @Test
    @DisplayName("타임아웃 실패 테스트")
    void timeoutExceeded_테스트2() {
        //
        assertThrows(AssertionFailedError.class,
                () -> assertTimeout(
                        ofSeconds(1), () -> {
                            Thread.sleep(2000);
                            System.out.println("실패!");
                        }
                )
        );

    }
}

class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
