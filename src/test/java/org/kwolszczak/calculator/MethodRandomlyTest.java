package org.kwolszczak.calculator;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@Epic("Epic Allure report")
//@Feature("Feature1")
@Order(1)
@TestMethodOrder(MethodOrderer.Random.class)
public class MethodRandomlyTest {

    @Test
    void methodA(){
        System.out.println("testA");

    }

    @Test
    void methodB(){
        System.out.println("testB");
    }

    @Test
    void methodC(){
        System.out.println("testC");
    }

    @Test
    void methodD(){
        System.out.println("testD");
    }
}
