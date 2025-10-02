package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest
{
    @DisplayName("Kiem thu gia tri bien (13  testcase)")
    @ParameterizedTest(name = "GTB {index} => goals={0}, fairPlay={1}, fans={2} -> {3}")
    @CsvSource(value = {
            "7, 5.0, 0, Đồng",
            "7, 5.0, 1, Đồng",
            "7, 5.0, 50000, Bạc",
            "7, 5.0, 99999, Bạc",
            "7, 5.0, 100000, Bạc",
            "7, 0.0, 50000, Chơi xấu",
            "7, 0.1, 50000, Chơi xấu",
            "7, 9.9, 50000, Vàng",
            "7, 10.0, 50000, Vàng",
            "0, 5.0, 50000, Đồng",
            "1, 5.0, 50000, Đồng",
            "14, 5.0, 50000, Bạc",
            "15, 5.0, 50000, Bạc"
    })
    void classify_boundary_cases(int goals, double fairPlay, int fans, String expected) {
        assertEquals(expected, App.classify(goals, fairPlay, fans));
    }

    @DisplayName("Kiem thu bang quyet dinh (6 testcase)")
    @ParameterizedTest(name = "BQD {index} => goals={0}, fairPlay={1}, fans={2} -> {3}")
    @CsvSource(value = {
            "7, 2.9, 80000, Chơi xấu",
            "5, 8.0, 60000, Vàng",
            "4, 9.0, 90000, Bạc",
            "5, 6.9, 50000, Bạc",
            "8, 8.0, 49999, Bạc",
            "6, 3.0, 90000, Đồng"
    })
    void classify_decision_table_cases(int goals, double fairPlay, int fans, String expected) {
        assertEquals(expected, App.classify(goals, fairPlay, fans));
    }
}
