package tema2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void miles2KilometersTest() {
        assertEquals( 1.60934, Utils.miles2kilometers(1), 0.00000001);
        assertEquals( -1.60934, Utils.miles2kilometers(-1), 0.00000001);
        assertEquals( 0, Utils.miles2kilometers(0), 0.00000001);
    }

    @Test
    void getTaxesTest() {
        assertEquals( 0, Utils.getTaxes(0, 21.0), 0.001);
        assertEquals( 0, Utils.getTaxes(1, 0), 0.001);
        assertEquals( 2.1, Utils.getTaxes(10.0, 21.0), 0.001);
        assertEquals( 0.67, Utils.getTaxes(3.19, 21.0), 0.001);
        assertEquals( -2.1, Utils.getTaxes(-10.0, 21.0), 0.001);
        assertEquals( -0.67, Utils.getTaxes(-3.19, 21.0), 0.001);
        assertEquals( -0.67, Utils.getTaxes(-3.191, 21.0), 0.001);
        assertEquals( -0.67, Utils.getTaxes(-3.19999, 21.0), 0.001);
        assertEquals( 0.14, Utils.getTaxes(0.69, 21.0), 0.001);
        assertEquals( 0.15, Utils.getTaxes(0.699, 21.0), 0.001);
    }

    @Test
    void netPriceTest() {
        assertEquals( 0, Utils.getNetPrice(0, 21.0), 0.001);
        assertEquals( 1, Utils.getNetPrice(1, 0), 0.001);
        assertEquals( 12.1, Utils.getNetPrice(10.0, 21.0), 0.001);
        assertEquals( 3.86, Utils.getNetPrice(3.19, 21.0), 0.001);
        assertEquals( -12.1, Utils.getNetPrice(-10.0, 21.0), 0.001);
        assertEquals( -3.86, Utils.getNetPrice(-3.19, 21.0), 0.001);
        assertEquals( -3.86, Utils.getNetPrice(-3.191, 21.0), 0.001);
        assertEquals( -3.87, Utils.getNetPrice(-3.199, 21.0), 0.001);
    }

    @Test
    void getCoinsTest() {
        assertEquals( 0, Utils.getCoins(0));
        assertEquals( 11020110, Utils.getCoins(3.47));
        assertEquals( 10000001, Utils.getCoins(2.01));
        assertEquals( 10100001, Utils.getCoins(2.51));
    }

    @Test
    void getNIFTest() {
        assertEquals( 'Z', Utils.getNIF(12345678));
    }

    @Test
    void isValidNIFTest() {
        assertTrue(Utils.isValidNIF(12345678,'Z'));
        assertTrue(Utils.isValidNIF(12345678,'z'));
        assertFalse(Utils.isValidNIF(12345678,'A'));
    }


}