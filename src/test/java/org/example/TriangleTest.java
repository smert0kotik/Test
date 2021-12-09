package org.example;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;


public class TriangleTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Проверка на соответствие полученной фигуры треугольнику")
    public void Triangle() {

        Assertions.assertDoesNotThrow(() -> new Triangle(2, 3, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Triangle(200, 3, 4));
    }

    @Test
    @DisplayName("Проверка на вычисление площади треугольника по трем сторонам")
    public void Square() {

        Assertions.assertEquals(2.9047375096555625, new Triangle(2, 3, 4).square());
        logger.info("Успешно");
    }

}




