package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Kiemthudongdulieu {
    @DisplayName("Kiem thu dong du lieu (3 testcase)")
    @ParameterizedTest(name = "DDL {index} => goals={0}, fairPlay={1}, fans={2} -> {3}")
    @CsvSource(value = {
            "25, 1.0, 20000, Chơi xấu",
            "5, 7.0, 50000, Vàng",
            "1, 4.0, 1000, Đồng"
    })
    void classify_ddk_cases(int goals, double fairPlay, int fans, String expected) {
        assertEquals(expected, App.classify(goals, fairPlay, fans));
    }
}
