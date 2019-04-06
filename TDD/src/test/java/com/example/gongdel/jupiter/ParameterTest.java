package com.example.gongdel.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterTest {

    @DisplayName("@ValueSource String 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void parameterized_stirng(String candidate) {
        List<String> strings = Arrays.asList("racecar", "radar", "able was I ere I saw elba");
        assertTrue(strings.contains(candidate));
    }

    @DisplayName("@ValueSource int 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void parameterized_int(int candidate) {
        List<Integer> lists = Arrays.asList(1, 2, 3, 4);
        assertTrue(lists.contains(candidate));
    }

    /**
     * EnumSource는 Enum 상수를 사용하기 위한 편리한 방법을 제공한다.
     * annotation은 Enum의 어떤 상수가 사용될 건지를 특정 지을 수 있지만, - testWithEnumSourceInclude()
     * 만약 생략하면 모든 상수가 사용된다 - testWithEnumSource
     *
     */
    // Tag - @EnumSource
    @DisplayName("@EnumSource int 테스트")
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }
    // End - @EnumSource

    @DisplayName("@NullSource 테스트")
    @ParameterizedTest
    @NullSource
    void nullSource(String text) {
        assertTrue(text == null);
    }


    @DisplayName("@EmptySource 테스트")
    @ParameterizedTest
    @EmptySource
    void emptySource(String text) {
        assertTrue(text == "");
    }


    @DisplayName("@EmptySource, @NullSource 테스트")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }


    @DisplayName("@NullAndEmptySource 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings2(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

}
