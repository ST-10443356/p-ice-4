/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog.ice.pkg1;

/**
 *
 * @author Sihle
 */
public class EstateAgentApp {
    public static void main(String[] args) {
        double[][] salesData = {
            {800000, 1500000, 2000000}, // Joe Bloggs
            {700000, 1200000, 1600000}  // Jane Doe
        };

        EstateAgent agent = new EstateAgent();

        double joeTotalSales = agent.EstateAgentSales(salesData[0]);
        double janeTotalSales = agent.EstateAgentSales(salesData[1]);

        double joeCommission = agent.EstateAgentCommission(joeTotalSales);
        double janeCommission = agent.EstateAgentCommission(janeTotalSales);

        int topAgentIndex = agent.TopEstateAgent(new double[]{joeTotalSales, janeTotalSales});
        String topAgent = (topAgentIndex == 0) ? "Joe Bloggs" : "Jane Doe";

        System.out.println("Total property sales for Joe Bloggs = R " + joeTotalSales);
        System.out.println("Total property sales for Jane Doe = R " + janeTotalSales);
        System.out.println("Sales Commission for Joe Bloggs = R " + joeCommission);
        System.out.println("Sales Commission for Jane Doe = R " + janeCommission);
        System.out.println("Top performing estate agent: " + topAgent);
    }
}