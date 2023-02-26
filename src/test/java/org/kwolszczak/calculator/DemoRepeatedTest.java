package org.kwolszczak.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Order(3)
@DisplayName("Test 3 DemoRepeated class")
public class DemoRepeatedTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        //Arrange //Given
        calculator = new Calculator();
    }


    //Test repeated nie potrzebuje annotacji @Test
    @RepeatedTest(3)
    @DisplayName("integerDivision: 4/0 -> Exception")
    void testCalculator_integerDivision_returnException() {

        //Act //When
        ArithmeticException resultException = assertThrows(ArithmeticException.class,
                () -> calculator.integerDivision(4, 0),
                "Division by zero throws Exception");

        //Assert //Then
        assertEquals(resultException.getMessage(), "/ by zero", "There should be Arithmetic exception");
    }


}
