package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Kiemthudongdieukhien {
    @DisplayName("Kiem thu dong dieu khien (13 testcase)")
    @ParameterizedTest(name = "DDK {index} => goals={0}, fairPlay={1}, fans={2} -> {3}")
    @CsvSource(value = {
            "5, 1.0, 40000, Chơi xấu",
            "33, 9.0, 50000, Vàng",
            "10, 6.0, 40000, Bạc",
            "2, 8.0, 30000, Đồng"
    })
    void classify_ddk_cases(int goals, double fairPlay, int fans, String expected) {
        assertEquals(expected, App.classify(goals, fairPlay, fans));
    }
}
