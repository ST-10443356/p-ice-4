/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package progb.ice3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sihle
 */
public class IEstateAgentTest {
    
    public IEstateAgentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of CalculateCommission method, of class IEstateAgent.
     */
    @Test
    public void testCalculateCommission() {
        System.out.println("CalculateCommission");
        String propertyPrice = "";
        String agentCommission = "";
        IEstateAgent instance = new IEstateAgentImpl();
        double expResult = 0.0;
        double result = instance.CalculateCommission(propertyPrice, agentCommission);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidateData method, of class IEstateAgent.
     */
    @Test
    public void testValidateData() {
        System.out.println("ValidateData");
        String agentName = "";
        String propertyPrice = "";
        String commissionPercentage = "";
        IEstateAgent instance = new IEstateAgentImpl();
        boolean expResult = false;
        boolean result = instance.ValidateData(agentName, propertyPrice, commissionPercentage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IEstateAgentImpl implements IEstateAgent {

        public double CalculateCommission(String propertyPrice, String agentCommission) {
            return 0.0;
        }

        public boolean ValidateData(String agentName, String propertyPrice, String commissionPercentage) {
            return false;
        }
    }
    
}
