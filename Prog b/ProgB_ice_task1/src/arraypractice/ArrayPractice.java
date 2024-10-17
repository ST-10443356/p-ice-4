/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraypractice;


public class ArrayPractice {
double [][] cameraPrices;
String [] cameraName;

public ArrayPractice() {
        cameraPrices = new double[][]{
            {10500.00 , 8500.00},
            {9500.00 , 7200.00},
            {12000.00 , 8000.00}
        };
        cameraName = new String[]{"CANON", "SONY", "NIKON"};
    }
    
    public static void array(){
        
        double [][] cameraPrices = {
            {10500.00 , 8500.00},
            {9500.00 , 7200.00},
            {12000.00 , 8000.00}
        };
        
        String [] cameraName = {"CANON","SONY","NIKON"};
        
        String [] cameraType = {"MIRRORLESS","DSLR"};
        
        System.out.println("               "+cameraType[0]+"     "+cameraType[1]);
        
        for(int i = 0 ; i < cameraPrices.length ; i++) {
            
                System.out.println(cameraName[i]+"              "+cameraPrices[i][0]+"         "+cameraPrices[i][1]);

        }
        
    }
    
    public void calculation(){
        
        
            
        double canonCalculation = cameraPrices[0][0]-cameraPrices[0][1];
        double sonyCalculation = cameraPrices[1][0]-cameraPrices[1][1];
        double nikonCalculation = cameraPrices[2][0]-cameraPrices[2][1];
        
        
            
                System.out.println(cameraName[0]+"    "+canonCalculation);
                System.out.println(cameraName[1]+"    "+sonyCalculation);
                System.out.println(cameraName[2]+"    "+nikonCalculation);

        
        
    }
    
    
    public static void main(String[] args) {
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("CAMERA TECHNOLOGY REPORT");
        System.out.println("--------------------------------------------------------------");
        
        array();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("CAMERA TECHNOLOGY RESULTS");
        System.out.println("--------------------------------------------------------------");
        
        ArrayPractice c = new ArrayPractice();
        
        
        c.calculation();
        
    }
    
}
