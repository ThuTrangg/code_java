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
public class vuong  extends hcn{
   double canh;

    public vuong(double canh){
        super(canh,canh);
this.canh=canh;
}
 public double getchuvi(){
         return  this.canh*4;
        }
        public double getdientich(){
            return this.canh*this.canh;
        }
    public void xuat(){
        System.out.println("Cạnh :"+this.canh);
        System.out.println("Chu vi hình vuông :"+getchuvi());
        System.out.println("Diện tích hình vuông:"+getdientich());
    }
    
}
