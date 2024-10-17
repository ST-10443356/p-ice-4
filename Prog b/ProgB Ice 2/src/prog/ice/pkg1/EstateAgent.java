/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ice.pkg1;

/**
 *
 * @author Sihle
 */
public class EstateAgent implements IEstateAgent {
    @Override
    public double EstateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    @Override
    public double EstateAgentCommission(double propertySales) {
        return propertySales * 0.02;
    }

    @Override
    public int TopEstateAgent(double[] totalSales) {
        if (totalSales[0] > totalSales[1]) {
            return 0; // Joe Bloggs
        } else {
            return 1; // Jane Doe
        }
    }
}

