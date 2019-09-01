
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Thu Trang
 */
public class Strock  implements Serializable{
    private int id;
    private String desc;
    private double price;
    private int quantity;
    public Strock(int id,String desc,double price,int quantity){
    this.id=id;
    this.desc=desc;
    this.price=price;
    this.quantity=quantity;
}
    public String toString(){
        return(id+""+desc+""+price+""+quantity);
    }
    
}
