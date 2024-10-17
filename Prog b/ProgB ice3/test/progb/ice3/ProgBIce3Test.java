/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package progb.ice3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgBIce3Test {
    private ProgBIce3 estateAgentApp;

    @BeforeEach
    void setUp() {
        estateAgentApp = new ProgBIce3();  // Initialize before each test
    }

    @Test
    void testCalculateCommission_ValidInput() {
        // Test for valid inputs for commission calculation
        double commission = estateAgentApp.CalculateCommission("1000000", "5");
        assertEquals(50000.0, commission, "Commission should be correctly calculated as 50000");
    }

    @Test
    void testCalculateCommission_InvalidInput() {
        // Test for invalid input (non-numeric)
        assertThrows(NumberFormatException.class, () -> {
            estateAgentApp.CalculateCommission("invalidPrice", "10");
        }, "Expected NumberFormatException for invalid property price");

        assertThrows(NumberFormatException.class, () -> {
            estateAgentApp.CalculateCommission("100000", "invalidCommission");
        }, "Expected NumberFormatException for invalid commission percentage");
    }

    @Test
    void testValidateData_ValidInput() {
        // Test for valid input validation
        boolean isValid = estateAgentApp.ValidateData("John Doe", "500000", "10");
        assertTrue(isValid, "The input should be considered valid");
    }

    @Test
    void testValidateData_InvalidName() {
        // Test for invalid agent name (empty)
        boolean isValid = estateAgentApp.ValidateData("", "500000", "10");
        assertFalse(isValid, "The input should be invalid because agent name is empty");
    }

    @Test
    void testValidateData_InvalidPrice() {
        // Test for invalid property price (negative and zero)
        boolean isValid1 = estateAgentApp.ValidateData("John Doe", "-500", "10");
        assertFalse(isValid1, "The input should be invalid because property price is negative");

        boolean isValid2 = estateAgentApp.ValidateData("John Doe", "0", "10");
        assertFalse(isValid2, "The input should be invalid because property price is zero");
    }

    @Test
    void testValidateData_InvalidCommission() {
        // Test for invalid commission percentage (negative and zero)
        boolean isValid1 = estateAgentApp.ValidateData("John Doe", "500000", "-5");
        assertFalse(isValid1, "The input should be invalid because commission percentage is negative");

        boolean isValid2 = estateAgentApp.ValidateData("John Doe", "500000", "0");
        assertFalse(isValid2, "The input should be invalid because commission percentage is zero");
    }
}
