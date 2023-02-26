package org.kwolszczak.calculator;

import org.junit.jupiter.api.*;


//tutaj kolejnosc wykonywania klas order
//wowolanie jest w pliku konfiguracyjnym: junit-platform.prperties
@Order(2)
// tutaj mamy jedna instancje klasy. Wszystkie metody wykonywane sa w tej samej instancji
//standardowo kazda metoda ma powolana oddzielna instancje klasy, Wtedy metody nie moga przekazywac miedzy soba argumentow
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//wywolywanie metod po kolejnosci order
//przydatne w testach integracyjnych
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test 2 MethodIndex class")
public class MethodIndexTest {

    @AfterEach
    void afterEach(){
        System.out.println(stringBuilder.toString());
    }

    StringBuilder stringBuilder= new StringBuilder("");
    @Order(4)
    @Test
    void methodA(){
        System.out.println("testA");
        stringBuilder.append(4);

    }

    @Order(3)
    @Test
    void methodB(){
        System.out.println("testB");
        stringBuilder.append(3);
    }

    @Order(2)
    @Test
    void methodC(){
        System.out.println("testC");
        stringBuilder.append(2);
    }

    @Order(1)
    @Test
    void methodD(){
        System.out.println("testD");
        stringBuilder.append(1);
    }

}
