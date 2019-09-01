/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide7;

/**
 *
 * @author Pham Thu Trang
 */
public enum Transport {
    
    CAR(65),TRUCK(55),AIRPLANE(600),TRAIN(70),BOAT(22);
    private int speed;
    Transport(int s){
        speed=s;
        
    }
    int getSpeed(){
        return speed;
    }
    public static void main(String[] args){
        Transport enu;
        enu=Transport.CAR;
        enu.getSpeed();
        System.out.println(enu.getSpeed());
        Transport enu1[]=Transport.values();
        for(int i=0;i<enu1.length;i++){
            System.out.println(enu1[i]+""+enu1[i].getSpeed());
        }
        
        
    }
   
    
    
    
}
