package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

   private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    int countTests;
    Boolean myBoolean = true;

    @Test
    @DisplayName("test1")
    void test1AreaofTriangle(){
        logger.info("Запускаем Тест1");
        assertEquals(6, FormulaSquareTriangle.triangleSquare(4,4,4) , "Площадь не верна");
        countTests++;
    }

    @Test
    @DisplayName("test2")
    void testException1(){
        logger.info("Запускаем Тест2");
        Assertions.assertThrows(NullPointerException.class, ()-> test2AreaofTriangle(), "Исключение не сработало");
    }

    private void test2AreaofTriangle(){
        assertEquals(6, FormulaSquareTriangle.triangleSquare(0,4,4) , "Площадь не верна");
        countTests++;
    }

    @Test
    @DisplayName("test3")
    void testException2(){
        logger.info("Запускаем Тест3");
        Assertions.assertThrows(NullPointerException.class, ()-> test3AreaofTriangle(), "Исключение не сработало");
    }

    private void test3AreaofTriangle(){
        assertEquals(6, FormulaSquareTriangle.triangleSquare(4,-4,4) , "Площадь не верна");
        countTests++;
    }

    @Test
    @DisplayName("test4")
    void testException3(){
        logger.info("Запускаем Тест4");
        Assertions.assertThrows(NullPointerException.class, ()-> test4AreaofTriangle(), "Исключение не сработало");
    }

    private void test4AreaofTriangle(){
        assertEquals(6, FormulaSquareTriangle.triangleSquare(4,4,444) , "Площадь не верна");
        countTests++;
    }

}
