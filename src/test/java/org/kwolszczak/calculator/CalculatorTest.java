package org.kwolszczak.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Order(4)
@DisplayName("Test Calculator class")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        //Arrange //Given
        calculator = new Calculator();
    }

    //test parametryzowany , bez annotacji @Test
    @ParameterizedTest
    @DisplayName("valueSourceDemonstration")
    @ValueSource(strings = {"Kate", "Tom", "Bob"})
    void testCalculator_valueSourceDemonstration(String name){
        assertNotNull(name);

    }

    @Test
    @DisplayName("integerDivision: 4/2 -> 2")
    void testCalculator_integerDivision_returnValue() {

        //Act //When
        int result = calculator.integerDivision(4, 2);

        //Assert //Then
        assertEquals(2, result, "4/2 did not produce 2");
    }

    //Test Disabled- wylaczony, np do zrobienia na pozniej, poprawienia
    @Disabled
    @Test
    @DisplayName("integerDivision: 4/0 -> Exception")
    void testCalculator_integerDivision_returnException() {

        //Act //When
        ArithmeticException resultException = assertThrows(ArithmeticException.class,
                () -> calculator.integerDivision(4, 0),
                "Division by zero throws Exception");

        //Assert //Then
        assertEquals(resultException.getMessage(), "/ by zero", "There should be Arithmetic exception");
    }


    @ParameterizedTest
    @DisplayName("1 test(params): integerSubtraction: a-b -> value")
    // @MethodSource("integerSubtractParams")
    //@MethodSource ()- jezeli nazwa metody taka sama jak metody statycznej to nie trzeba podawac jej
    @MethodSource()
    void testCalculator_integerSubtraction_returnValue(int a, int b, int expectedResult) {

        //Act //When
        int result = calculator.integerSubtraction(a, b);

        //Assert //Then
        assertEquals(expectedResult, result, a + "-" + b + " did not return" + expectedResult);
    }

    @ParameterizedTest
    @DisplayName("2 test(params): integerSubtraction: a-b -> value")
    @CsvSource({
            "34,1,33",
            "47,4,43",
            "26,3,23"
    })
    void testCalculator_integerSubtraction_returnValue2(int a, int b, int expectedResult) {

        //Act //When
        int result = calculator.integerSubtraction(a, b);

        //Assert //Then
        assertEquals(expectedResult, result, a + "-" + b + " did not return" + expectedResult);
    }


    @ParameterizedTest
    @DisplayName("3 test(params): integerSubtraction: a-b -> value")
    @CsvFileSource(resources = "/integerParams.csv")
    void testCalculator_integerSubtraction_returnValue3(int a, int b, int expectedResult) {

        //Act //When
        int result = calculator.integerSubtraction(a, b);

        //Assert //Then
        assertEquals(expectedResult, result, a + "-" + b + " did not return" + expectedResult);
    }


    //Metoda statyczna, potrzebna do testu parametrycznego
    private static Stream<Arguments> testCalculator_integerSubtraction_returnValue() {

        return Stream.of(
                Arguments.of(55, 1, 54),
                Arguments.of(66, 1, 65),
                Arguments.of(77, 1, 76)
        );


    }
}