package com.example.gongdel.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("@RepeatedTest 샘플")
public class RepeatTest {

    @DisplayName("RepeatitionInfo 정보 테스트")
    @RepeatedTest(3)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("name 정보 활용 테스트")
    void customDisplayName(TestInfo testInfo) {
        assertEquals("name 정보 활용 테스트 1/3", testInfo.getDisplayName());
    }

}