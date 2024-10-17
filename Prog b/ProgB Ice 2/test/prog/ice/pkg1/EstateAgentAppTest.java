/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package prog.ice.pkg1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstateAgentTest {
    private EstateAgent agent;
    
    @BeforeEach
    void setUp() {
        agent = new EstateAgent();  // Create a new EstateAgent instance before each test
    }

    @Test
    void testEstateAgentSales() {
        // Test case for Joe Bloggs' sales
        double[] joeSales = {800000, 1500000, 2000000};
        double expectedJoeSales = 4300000;  // Expected total sales for Joe Bloggs
        assertEquals(expectedJoeSales, agent.EstateAgentSales(joeSales), 
                     "Total sales for Joe Bloggs should be 4,300,000");

        // Test case for Jane Doe's sales
        double[] janeSales = {700000, 1200000, 1600000};
        double expectedJaneSales = 3500000;  // Expected total sales for Jane Doe
        assertEquals(expectedJaneSales, agent.EstateAgentSales(janeSales), 
                     "Total sales for Jane Doe should be 3,500,000");
    }

    @Test
    void testEstateAgentCommission() {
        // Test case for Joe Bloggs' commission (5% of 4,300,000)
        double joeTotalSales = 4300000;
        double expectedJoeCommission = 215000;  // Expected commission for Joe Bloggs
        assertEquals(expectedJoeCommission, agent.EstateAgentCommission(joeTotalSales), 
                     "Joe Bloggs' commission should be 215,000");

        // Test case for Jane Doe's commission (5% of 3,500,000)
        double janeTotalSales = 3500000;
        double expectedJaneCommission = 175000;  // Expected commission for Jane Doe
        assertEquals(expectedJaneCommission, agent.EstateAgentCommission(janeTotalSales), 
                     "Jane Doe's commission should be 175,000");
    }

    @Test
    void testTopEstateAgent() {
        // Test case where Joe Bloggs has higher total sales than Jane Doe
        double[] totalSales = {4300000, 3500000};  // Joe Bloggs' and Jane Doe's total sales
        int expectedTopAgentIndex = 0;  // Joe Bloggs has the highest sales
        assertEquals(expectedTopAgentIndex, agent.TopEstateAgent(totalSales), 
                     "Joe Bloggs should be the top estate agent");

        // Test case where Jane Doe has higher total sales than Joe Bloggs
        double[] reversedSales = {3500000, 4300000};  // Jane Doe's sales are higher
        int expectedTopAgentIndexForJane = 1;  // Jane Doe has the highest sales
        assertEquals(expectedTopAgentIndexForJane, agent.TopEstateAgent(reversedSales), 
                     "Jane Doe should be the top estate agent");
    }
}
