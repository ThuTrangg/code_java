/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Pham Thu Trang
 */
public class hcn {
        double rong;
    double dai;

    public hcn(double rong,double dai){
       
       this.rong=rong;
       this.dai=dai; 
    }
    
        public double getchuvi(){
         return  (dai+rong)*2;
        }
        public double getdientich(){
            return (dai*rong);
        }
        public void xuat(){
            System.out.println("Chiều rộng :"+rong);
            System.out.println("Chiều dài:"+dai);
            System.out.println("Chu vi :"+getchuvi());
            System.err.println("Diện tích: "+getdientich());
        }
}
