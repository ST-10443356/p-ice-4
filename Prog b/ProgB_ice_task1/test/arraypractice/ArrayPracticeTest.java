/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package arraypractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayPracticeTest {
    private ArrayPractice arrayPractice;

    @BeforeEach
    void setUp() {
        arrayPractice = new ArrayPractice();  // Initialize before each test
    }

    @Test
    void testGetCameraData() {
        // Expected output from getCameraData()
        String[] expected = {
            "CANON 10500.0 8500.0",
            "SONY 9500.0 7200.0",
            "NIKON 12000.0 8000.0"
        };
        String[] actual = arrayPractice.getCameraData();
        assertArrayEquals(expected, actual, "Camera data should match the expected values");
    }

    @Test
    void testGetPriceDifferences() {
        // Expected price differences for the cameras
        double[] expected = {2000.0, 2300.0, 4000.0};
        double[] actual = arrayPractice.getPriceDifferences();
        assertArrayEquals(expected, actual, 0.01, "Price differences should match the expected values");
    }
}
