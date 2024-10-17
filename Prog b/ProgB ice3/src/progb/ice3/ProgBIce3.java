/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progb.ice3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ProgBIce3 extends JFrame implements IEstateAgent {
    // Swing components
    private JComboBox<String> locationComboBox;
    private JTextField agentNameField, propertyPriceField, commissionPercentageField;
    private JTextArea reportArea;
    private JMenuItem processReport, saveReport, clearFields, exitApp;

    // Constructor to set up the GUI
    public ProgBIce3() {
        // Frame setup
        setTitle("Estate Agent Report");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Components
        JLabel locationLabel = new JLabel("AGENT LOCATION:");
        locationComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
        JLabel nameLabel = new JLabel("ESTATE AGENT NAME:");
        agentNameField = new JTextField();
        JLabel priceLabel = new JLabel("PROPERTY PRICE:");
        propertyPriceField = new JTextField();
        JLabel commissionLabel = new JLabel("COMMISSION PERCENTAGE:");
        commissionPercentageField = new JTextField();
        JLabel reportLabel = new JLabel("ESTATE AGENT REPORT:");
        reportArea = new JTextArea(5, 20);
        reportArea.setEditable(false);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        processReport = new JMenuItem("Process Report");
        saveReport = new JMenuItem("Save Report");
        clearFields = new JMenuItem("Clear");
        exitApp = new JMenuItem("Exit");

        fileMenu.add(exitApp);
        toolsMenu.add(processReport);
        toolsMenu.add(saveReport);
        toolsMenu.add(clearFields);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Adding components to frame
        add(locationLabel);
        add(locationComboBox);
        add(nameLabel);
        add(agentNameField);
        add(priceLabel);
        add(propertyPriceField);
        add(commissionLabel);
        add(commissionPercentageField);
        add(reportLabel);
        add(new JScrollPane(reportArea));

        // Event handling
        processReport.addActionListener(new ProcessReportAction());
        saveReport.addActionListener(new SaveReportAction());
        clearFields.addActionListener(new ClearFieldsAction());
        exitApp.addActionListener(e -> System.exit(0));

        // Display the frame
        setVisible(true);
    }

    // ActionListener for Processing Report
    private class ProcessReportAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String location = (String) locationComboBox.getSelectedItem();
            String agentName = agentNameField.getText();
            String propertyPrice = propertyPriceField.getText();
            String commissionPercentage = commissionPercentageField.getText();

            if (ValidateData(agentName, propertyPrice, commissionPercentage)) {
                double commission = CalculateCommission(propertyPrice, commissionPercentage);
                String report = String.format(
                        "AGENT LOCATION: %s\nAGENT NAME: %s\nPROPERTY PRICE: R %s\nCOMMISSION PERCENTAGE: %s%%\nCALCULATED COMMISSION: R %.2f",
                        location, agentName, propertyPrice, commissionPercentage, commission);
                reportArea.setText(report);
            } else {
                reportArea.setText("Invalid input. Please check your data.");
            }
        }
    }

    // ActionListener for Saving Report
    private class SaveReportAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileWriter writer = new FileWriter("report.txt");
                writer.write(reportArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(null, "Report saved to report.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving report.");
                ex.printStackTrace();
            }
        }
    }

    // ActionListener for Clearing Fields
    private class ClearFieldsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            agentNameField.setText("");
            propertyPriceField.setText("");
            commissionPercentageField.setText("");
            reportArea.setText("");
        }
    }

    // Implementing IEstateAgent methods
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double commission = Double.parseDouble(agentCommission);
        return (price * commission) / 100;
    }

    @Override
    public boolean ValidateData(String agentName, String propertyPrice, String commissionPercentage) {
        if (agentName.isEmpty()) return false;
        try {
            if (Double.parseDouble(propertyPrice) <= 0) return false;
            if (Double.parseDouble(commissionPercentage) <= 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new ProgBIce3();
    }
}

// Interface definition
interface IEstateAgent {
    double CalculateCommission(String propertyPrice, String agentCommission);
    boolean ValidateData(String agentName, String propertyPrice, String commissionPercentage);
}

