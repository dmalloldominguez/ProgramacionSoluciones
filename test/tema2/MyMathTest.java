package tema2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    @Test
    void squarePerimeterTest() {
        assertEquals( 40.4, MyMath.squarePerimeter(10.1), 0.1);
        assertEquals( 0, MyMath.squarePerimeter(0), 0.1);
        assertEquals( 0, MyMath.squarePerimeter(-1), 0.1, "Un lado negativo devuelve perímetro 0");
        assertEquals( 40.004, MyMath.squarePerimeter(10.001), 0.000000001, "Precisión insuficiente");
    }

    @Test
    void squareAreaTest() {
        assertEquals( 102.01, MyMath.squareArea(10.1), 0.1);
        assertEquals( 0, MyMath.squareArea(0), 0.1);
        assertEquals( 0, MyMath.squareArea(-1), 0.1, "Un lado negativo devuelve área 0");
        assertEquals( 102.01, MyMath.squareArea(10.1), 0.000000001, "Precisión insuficiente");
    }

    @Test
    void rectanglePerimeterTest() {
        assertEquals( 40, MyMath.rectanglePerimeter(10, 10), 0.1);
        assertEquals( 0, MyMath.rectanglePerimeter(0, 10), 0.1);
        assertEquals( 0, MyMath.rectanglePerimeter(10, 0), 0.1);
        assertEquals( 0, MyMath.rectanglePerimeter(-1, 10), 0.1, "Un lado negativo devuelve perímetro 0");
        assertEquals( 0, MyMath.rectanglePerimeter(10, -1), 0.1, "Un lado negativo devuelve perímetro 0");
        assertEquals( 40, MyMath.rectanglePerimeter(10, 10), 0.000000001, "Precisión insuficiente");
    }
    @Test
    void rectangleAreaTest() {
        assertEquals( 100, MyMath.rectangleArea(10, 10), 0.1);
        assertEquals( 0, MyMath.rectangleArea(0, 10), 0.1);
        assertEquals( 0, MyMath.rectangleArea(10, 0), 0.1);
        assertEquals( 0, MyMath.rectangleArea(-1, 10), 0.1, "Un lado negativo devuelve área 0");
        assertEquals( 0, MyMath.rectangleArea(10, -10), 0.1, "Un lado negativo devuelve área 0");
        assertEquals( 102.01, MyMath.rectangleArea(10.1, 10.1), 0.000000001, "Precisión insuficiente");
    }
    @Test
    void circlePerimeterTest() {
        assertEquals( 62.83, MyMath.circlePerimeter(10), 0.1);
        assertEquals( 0, MyMath.circlePerimeter(0), 0.1);
        assertEquals( 0, MyMath.circlePerimeter(-1), 0.1, "Un radio negativo devuelve perímetro 0");
        assertEquals( 62.8318530718, MyMath.circlePerimeter(10), 0.000000001, "Precisión insuficiente");
    }
    @Test
    void circleAreaTest() {
        assertEquals( 314.16, MyMath.circleArea(10), 0.1);
        assertEquals( 0, MyMath.circleArea(0), 0.1);
        assertEquals( 0, MyMath.circleArea(-1), 0.1, "Un radio negativo devuelve área 0");
        assertEquals( 314.159265359, MyMath.circleArea(10), 0.000000001, "Precisión insuficiente");
    }
    @Test
    void primeTest() {
        assertFalse(MyMath.isPrime(10), "10 no es primo");
        assertTrue(MyMath.isPrime(103), "103 es primo");
        assertFalse(MyMath.isPrime(1), "1 no es primo");
        assertFalse(MyMath.isPrime(0), "0 no es primo");
        assertFalse(MyMath.isPrime(-1), "Los números negativos no son primos");
    }

    @Test
    void notPrimeTest() {
        assertTrue(MyMath.isNotPrime(10), "10 no es primo");
        assertFalse(MyMath.isNotPrime(103), "103 es primo");
        assertTrue(MyMath.isNotPrime(1), "1 no es primo");
        assertTrue(MyMath.isNotPrime(0), "0 no es primo");
        assertTrue(MyMath.isNotPrime(-1), "Los números negativos no son primos");
    }

    @Test
    void figureCountTest() {
        assertEquals(1, MyMath.figureCount(1), "1 tiene 1 dígito");
        assertEquals(3, MyMath.figureCount(999), "999 tiene 3 dígitos");
        assertEquals(1, MyMath.figureCount(0), "0 tiene 1 dígito");
        assertEquals(3, MyMath.figureCount(-100), "-100 tiene 3 dígitos");
    }

    @Test
    void evenFigureCountTest() {
        assertEquals(0, MyMath.evenFigureCount(1), "1 tiene 0 dígitos pares");
        assertEquals(1, MyMath.evenFigureCount(2), "2 tiene 1 dígito par");
        assertEquals(0, MyMath.evenFigureCount(999), "999 tiene 0 dígitos pares");
        assertEquals(1, MyMath.evenFigureCount(123), "123 tiene 1 dígito par");
        assertEquals(1, MyMath.evenFigureCount(0), "0 tiene 1 dígito par");
        assertEquals(2, MyMath.evenFigureCount(-100), "-100 tiene 2 dígitos pares");
    }
    @Test
    void oddFigureCountTest() {
        assertEquals(1, MyMath.oddFigureCount(1), "1 tiene 1 dígito impar");
        assertEquals(0, MyMath.oddFigureCount(2), "2 tiene 0 dígito impares");
        assertEquals(3, MyMath.oddFigureCount(999), "999 tiene 3 dígitos impares");
        assertEquals(2, MyMath.oddFigureCount(123), "123 tiene 2 dígitos impares");
        assertEquals(0, MyMath.oddFigureCount(0), "0 tiene 0 dígitos impares");
        assertEquals(1, MyMath.oddFigureCount(-100), "-100 tiene 1 dígitos impar");
    }

    @Test
    void factorialTest() {
        assertEquals(2, MyMath.factorial(2), "2! = 1");
        assertEquals(1, MyMath.factorial(0), "0! = 1");
        assertEquals(1, MyMath.factorial(1), "1! = 1");
        assertEquals(3628800, MyMath.factorial(10), "10! = 3628800");
        assertEquals(0, MyMath.factorial(-1), "-1! = 0, vamos a suponer que el factorial de un número negativo es 0");
    }
    @Test
    void factorialRecursiveTest() {
        assertEquals(2, MyMath.factorialRecursive(2), "2! = 1");
        assertEquals(1, MyMath.factorialRecursive(0), "0! = 1");
        assertEquals(1, MyMath.factorialRecursive(1), "1! = 1");
        assertEquals(3628800, MyMath.factorialRecursive(10), "10! = 3628800");
        assertEquals(0, MyMath.factorialRecursive(-1), "-1! = 0, vamos a suponer que el factorial de un número negativo es 0");
    }
    @Test
    void quadraticEcuationSolutionsTest() {
        assertEquals(2, MyMath.quadraticEcuationSolutions(-2 , 2, 1), "-2 X2 + 2 X + 1 = 0 has 2 solutions");
        assertEquals(0, MyMath.quadraticEcuationSolutions(3 , 2, 1), "3 X2 + 2 X + 1 = 0 has 0 solutions");
        assertEquals(1, MyMath.quadraticEcuationSolutions(1 , 2, 1), "1 X2 + 2 X + 1 = 0 has 1 solutions");
    }

    @Test
    void figuresSumatoryTest() {
        assertEquals(0, MyMath.figuresSumatory(0), "0 -> Todos los dígitos suman 0");
        assertEquals(1, MyMath.figuresSumatory(10), "10 -> Todos los dígitos suman 1");
        assertEquals(6, MyMath.figuresSumatory(123), "123 -> Todos los dígitos suman 6");
        assertEquals(6, MyMath.figuresSumatory(-123), "-123 -> Todos los dígitos suman 6");
    }

}